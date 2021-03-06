package cn.onlov.cms.common.cms.service;

import java.io.IOException;
import java.net.URI;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.onlov.cms.common.cms.api.Constants;
import cn.onlov.cms.common.common.image.ImageUtils;
import cn.onlov.cms.common.core.entity.CmsConfig;
import cn.onlov.cms.common.core.entity.CmsOss;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.entity.Ftp;
import cn.onlov.cms.common.core.manager.CmsConfigMng;
import cn.onlov.cms.common.core.manager.CmsSiteMng;
import cn.onlov.cms.common.core.manager.FtpMng;
import cn.onlov.cms.common.cms.entity.main.Content;
import cn.onlov.cms.common.cms.entity.main.ContentCount;
import cn.onlov.cms.common.cms.manager.assist.CmsAcquisitionHistoryMng;
import cn.onlov.cms.common.cms.manager.assist.CmsAcquisitionMng;
import cn.onlov.cms.common.cms.manager.assist.CmsAcquisitionTempMng;
import cn.onlov.cms.common.cms.manager.main.ContentCountMng;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.onlov.cms.common.cms.entity.assist.CmsAcquisition;
import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionHistory;
import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionReplace;
import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionShield;
import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionTemp;

@Service
public class AcquisitionSvcImpl implements AcquisitionSvc {
	private Logger log = LoggerFactory.getLogger(AcquisitionSvcImpl.class);

	public boolean start(Integer id) {
		CmsAcquisition acqu = cmsAcquisitionMng.findById(id);
		Set<CmsAcquisitionReplace> set=acqu.getReplaceWords();
		set.size();
		Set<CmsAcquisitionShield> shields=acqu.getShields();
		shields.size();
		if (acqu == null || acqu.getStatus() == CmsAcquisition.START) {
			return false;
		}
		Thread thread = new AcquisitionThread(acqu,set,shields);
		thread.start();
		return true;
	}
	
	private void end(CmsAcquisition acqu){
		Integer siteId = acqu.getSite().getId();
		cmsAcquisitionMng.end(acqu.getId());
		CmsAcquisition acquisition = cmsAcquisitionMng.popAcquFromQueue(siteId);
		if (acquisition != null) {
			Integer id = acquisition.getId();
			start(id);
		}
	}

	private CmsAcquisitionMng cmsAcquisitionMng;
	private CmsAcquisitionHistoryMng cmsAcquisitionHistoryMng;
	private CmsAcquisitionTempMng cmsAcquisitionTempMng;
	@Autowired
	private CmsSiteMng siteMng;
	@Autowired
	private CmsConfigMng cmsConfigMng;
	@Autowired
	private ImageSvc imgSvc;
	@Autowired
	private ContentCountMng contentCountMng;
	@Autowired
	private FtpMng ftpMng;

	@Autowired
	public void setCmsAcquisitionMng(CmsAcquisitionMng cmsAcquisitionMng) {
		this.cmsAcquisitionMng = cmsAcquisitionMng;
	}

	@Autowired
	public void setCmsAcquisitionHistoryMng(
			CmsAcquisitionHistoryMng cmsAcquisitionHistoryMng) {
		this.cmsAcquisitionHistoryMng = cmsAcquisitionHistoryMng;
	}

	@Autowired
	public void setCmsAcquisitionTempMng(
			CmsAcquisitionTempMng cmsAcquisitionTempMng) {
		this.cmsAcquisitionTempMng = cmsAcquisitionTempMng;
	}

	private class AcquisitionThread extends Thread {
		private CmsAcquisition acqu;
		private Set<CmsAcquisitionReplace> replaces;
		private Set<CmsAcquisitionShield> shields;
		public AcquisitionThread(CmsAcquisition acqu,Set<CmsAcquisitionReplace> replaces,Set<CmsAcquisitionShield> shields) {
			super(acqu.getClass().getName() + "#" + acqu.getId());
			this.acqu = acqu;
			this.replaces=replaces;
			this.shields=shields;
		}

		@Override
		public void run() {
			if (acqu == null) {
				return;
			}
			acqu = cmsAcquisitionMng.start(acqu.getId());
			String[] plans = acqu.getAllPlans();
			 HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
		     CloseableHttpClient client = httpClientBuilder.build();  
			CharsetHandler handler = new CharsetHandler(acqu.getPageEncoding());
			List<String> contentList;
			String url;
			int currNum = acqu.getCurrNum();
			int currItem = acqu.getCurrItem();
			Integer acquId = acqu.getId();		
			for (int i = plans.length - currNum; i >= 0; i--) {
				url = plans[i];
				contentList = getContentList(client, handler, url, acqu);
				String link;
				for (int j = contentList.size() - currItem; j >= 0; j--) {
					if (cmsAcquisitionMng.isNeedBreak(acqu.getId(),
							plans.length - i, contentList.size() - j,
							contentList.size())) {
						try {
							client.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						log.info("Acquisition#{} breaked", acqu.getId());
						return;
					}
					if (acqu.getPauseTime() > 0) {
						try {
							Thread.sleep(acqu.getPauseTime());
						} catch (InterruptedException e) {
							//log.warn(null, e);
							log.warn(e.getMessage());
						}
					}
					link = contentList.get(j);
					float curr = contentList.size() - j;
					float total = contentList.size();
					CmsAcquisitionTemp temp = AcquisitionSvcImpl.this.newTemp(
							url, link, contentList.size() - j, curr, total,
							acqu.getSite());
					CmsAcquisitionHistory history = AcquisitionSvcImpl.this
							.newHistory(url, link, acqu);
					CmsSite site=acqu.getSite();
					site=siteMng.findById(site.getId());
					CmsConfig config=cmsConfigMng.get();
					Ftp ftp=null;
                    CmsOss oss=null;
					if(site.getUploadFtp()!=null){
						Integer ftpId=site.getUploadFtp().getId();
						ftp=ftpMng.findById(ftpId);
					}
					if(site.getUploadOss()!=null){
						oss=site.getUploadOss();
					}
					saveContent(client, handler,config,site,acquId, link,
							ftp,oss,temp,history);
				}
				currItem = 1;
			}
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			AcquisitionSvcImpl.this.end(acqu);
			log.info("Acquisition#{} complete", acqu.getId());
		}

		private List<String> getContentList(HttpClient client,
				CharsetHandler handler, String url, CmsAcquisition acqu) {
			String linksetStart=acqu.getLinksetStart();
			String linksetEnd=acqu.getLinksetEnd();
			String linkStart=acqu.getLinkStart();
			String linkEnd=acqu.getLinkEnd();
			List<String> list = new ArrayList<String>();
			try {
				HttpGet httpget = new HttpGet(new URI(url));
				String base = url.substring(0, url.indexOf("/", url
						.indexOf("//") + 2));
				String html = client.execute(httpget, handler);							
				int start = html.indexOf(linksetStart);
				if (start == -1) {
					return list;	
				}
				start += linksetStart.length();
				int end = html.indexOf(linksetEnd, start);
				if (end == -1) {
					return list;
				}
				String s = html.substring(start, end);
				//批量屏蔽
				if (shields!=null) {
					for(CmsAcquisitionShield shield :shields){
						html=shieldContent(shield,s);
					}
				}				
				//批量替换
				if (replaces!=null) {
					for(CmsAcquisitionReplace replace :replaces){
						s=s.replaceAll(replace.getKeyword(), replace.getReplaceWord());
					}
				}	
				start = 0;
				String link;
				log.info(s);
				while ((start = s.indexOf(linkStart, start)) != -1) {
					start += linkStart.length();
					end = s.indexOf(linkEnd, start);
					if (end == -1) {
						return list;
					} else {
						link = s.substring(start, end);
						//内容地址前缀
						if(StringUtils.isNotBlank(acqu.getContentPrefix())){
							link=acqu.getContentPrefix()+link;
						}
						if (!link.startsWith("http")) {
							link = base + link;
						}
						list.add(link);
						start = end + linkEnd.length();
					}
				}
			} catch (Exception e) {
				//log.warn(null, e);
				log.warn(e.getMessage());
			}
			return list;
		}
		
		private String shieldContent(CmsAcquisitionShield shield,String html){
			String shieldStart=shield.getShieldStart();
			String shieldEnd=shield.getShieldEnd();
			int start=0;
			while ((start = html.indexOf(shieldStart, start)) != -1) {
				if (start == -1) {
					return html;	
				}
				start += shieldStart.length();
				int end = html.indexOf(shieldEnd, start);
				if (end == -1) {
					return html;
				}
				String s = html.substring(start, end);
				html=html.replace(s, "");
			}	
			return html;
		}

		private Content saveContent(HttpClient client, CharsetHandler handler, CmsConfig config,
                                    CmsSite site, Integer acquId, String url, Ftp ftp, CmsOss oss,
                                    CmsAcquisitionTemp temp, CmsAcquisitionHistory history) {
			CmsAcquisition acqu = cmsAcquisitionMng.findById(acquId);
			String titleStart=acqu.getTitleStart();
			String titleEnd=acqu.getTitleEnd();
			String contentStart=acqu.getContentStart();
			String contentEnd=acqu.getContentEnd();
			String viewStart=acqu.getViewStart();
			String viewEnd=acqu.getViewEnd();
			String viewIdStart=acqu.getViewIdStart();
			String viewIdEnd=acqu.getViewIdEnd();
			String viewLink=acqu.getViewLink();
			String authorStart=acqu.getAuthorStart();
			String authorEnd=acqu.getAuthorEnd();
			String originStart=acqu.getOriginStart();
			String originEnd=acqu.getOriginEnd();
			String originAppoint=acqu.getOriginAppoint();
			String releaseTimeStart=acqu.getReleaseTimeStart();
			String releaseTimeEnd=acqu.getReleaseTimeEnd();
			String descriptionStart=acqu.getDescriptionStart();
			String descriptionEnd=acqu.getDescriptionEnd();
			String typeImgStart=acqu.getTypeImgStart();
			String typeImgEnd=acqu.getTypeImgEnd();
			String contentPagePrefix=acqu.getContentPagePrefix();
			String contentPageStart=acqu.getContentPageStart();
			String contentPageEnd=acqu.getContentPageEnd();
			String pageLinkStart=acqu.getPageLinkStart();
			String pageLinkEnd=acqu.getPageLinkEnd();		
			
			history.setAcquisition(acqu);
			try {
				int start, end;
				HttpGet httpget = new HttpGet(new URI(url));
				String html = client.execute(httpget, handler);
				Set<String> set=new HashSet<String>();
			    //如果包含分页则获取分页链接
				if (StringUtils.isNotBlank(contentPageStart)&&StringUtils.isNotBlank(contentPageEnd)) {
					set=getPageList(set, 0, 0, html, contentPageStart, contentPageEnd,
							contentPagePrefix,pageLinkStart,pageLinkEnd);					
				}				
				start = html.indexOf(titleStart);
				if (start == -1) {
					return handerResult(temp, history, null,
							CmsAcquisition.AcquisitionResultType.TITLESTARTNOTFOUND);
				}
				start += titleStart.length();
				end = html.indexOf(titleEnd, start);
				if (end == -1) {
					return handerResult(temp, history, null,
							CmsAcquisition.AcquisitionResultType.TITLEENDNOTFOUND);
				}
				String title = html.substring(start, end);
				if (cmsAcquisitionHistoryMng
						.checkExistByProperties(true, title)) {
					return handerResult(temp, history, title,
							CmsAcquisition.AcquisitionResultType.TITLEEXIST, true);
				}
				start = html.indexOf(contentStart);
				if (start == -1) {
					return handerResult(temp, history, title,
							CmsAcquisition.AcquisitionResultType.CONTENTSTARTNOTFOUND);
				}
				start += contentStart.length();
				end = html.indexOf(contentEnd, start);
				if (end == -1) {
					return handerResult(temp, history, title,
							CmsAcquisition.AcquisitionResultType.CONTENTENDNOTFOUND);
				}
				String txt = html.substring(start, end);
				String typeImg=null;
				if(acqu.getImgAcqu()){
					List<String>imgUrls= ImageUtils.getImageSrc(txt);
					int firstImg=1;
					for(String img:imgUrls){
						String imgRealUrl;
						if(StringUtils.isNotBlank(acqu.getImgPrefix())){
							imgRealUrl=acqu.getImgPrefix()+img;
						}else{
							imgRealUrl=img;
						}
						String imageUrl=imgSvc.crawlImg(imgRealUrl, config.getContextPath(), 
								config.getUploadToDb(), config.getDbFileUri(), ftp,
								oss,site.getUploadPath());	
						if (firstImg==1) {
							//默认类型图默认第一张为类型图
							if (acqu.getDefTypeImg()) {					
								typeImg=imageUrl;
								// 图片路径需要与内容上传处统一，上传图片需要包含项目路径，删除此次原有去除项目路径代码
							}else{
								//根据规则获取类型图
								if (StringUtils.isNotBlank(typeImgStart)) {
									start = html.indexOf(typeImgStart);
									if (start == -1) {
										return handerResult(temp, history, null,
												CmsAcquisition.AcquisitionResultType.TYPEIMGSTARTNOTFOUND);
									}
									start += typeImgStart.length();
									end = html.indexOf(typeImgEnd, start);
									if (end == -1) {
										return handerResult(temp, history, null,
												CmsAcquisition.AcquisitionResultType.TYPEIMGENDNOTFOUND);
									}
									typeImg = html.substring(start, end);
									// 图片路径需要与内容上传处统一，上传图片需要包含项目路径，添加项目路径参数config.getContextPath()
									typeImg = imgSvc.crawlImg(typeImg, config.getContextPath(), 
											config.getUploadToDb(), config.getDbFileUri(), ftp,
											oss,site.getUploadPath());
								}		
							}							
						}
						
						txt=txt.replace(img, imageUrl);
					}
				}
				//存在分页情况时获取分页正文
				if (set.size()>0) {
					txt="";
					for(String PageUrl:set){
						txt+=getPageTxt(contentStart, contentEnd, PageUrl, client, handler, httpget, config, site, ftp, oss);
						txt+= Constants.NEXT_PAGE;
					}		
				}
				
				String author = null;
				if(StringUtils.isNotBlank(authorStart)){
					start = html.indexOf(authorStart);
					if (start == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.AUTHORSTARTNOTFOUND);
					}
					start += authorStart.length();
					end = html.indexOf(authorEnd, start);
					if (end == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.AUTHORENDNOTFOUND);
					}
					author = html.substring(start, end);
				}
				
				String origin = null;
				if(StringUtils.isNotBlank(originAppoint)){
					origin=originAppoint;
				}else{
					if(StringUtils.isNotBlank(originStart)){
						start = html.indexOf(originStart);
						if (start == -1) {
							return handerResult(temp, history, null,
									CmsAcquisition.AcquisitionResultType.ORIGINSTARTNOTFOUND);
						}
						start += originStart.length();
						end = html.indexOf(originEnd, start);
						if (end == -1) {
							return handerResult(temp, history, null,
									CmsAcquisition.AcquisitionResultType.ORIGINENDNOTFOUND);
						}
						origin = html.substring(start, end);
					}
				}
				
				String description = null;
				if(StringUtils.isNotBlank(descriptionStart)){
					start = html.indexOf(descriptionStart);
					if (start == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.DESCRISTARTNOTFOUND);
					}
					start += descriptionStart.length();
					end = html.indexOf(descriptionEnd, start);
					if (end == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.DESCRIENDNOTFOUND);
					}
					description = html.substring(start, end);
				}
				
				Date releaseTime = null;
				if(StringUtils.isNotBlank(releaseTimeStart)){
					start = html.indexOf(releaseTimeStart);
					if (start == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.RELEASESTARTNOTFOUND);
					}
					start += releaseTimeStart.length();
					end = html.indexOf(releaseTimeEnd, start);
					if (end == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.RELEASEENDNOTFOUND);
					}
					String releaseDate= html.substring(start, end);
					SimpleDateFormat df=new SimpleDateFormat(acqu.getReleaseTimeFormat());
					releaseTime=df.parse(releaseDate);
				}


				String view = null;
				if(StringUtils.isNotBlank(viewLink)){
					start = html.indexOf(viewIdStart);
					if (start == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.VIEWIDSTARTNOTFOUND);
					}
					start += viewIdStart.length();
					end = html.indexOf(viewIdEnd, start);
					if (end == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.VIEWIDENDNOTFOUND);
					}
					viewLink+=html.substring(start, end);
					HttpGet viewHttpGet = new HttpGet(new URI(viewLink));
					html = client.execute(viewHttpGet, handler);
				}
				if(StringUtils.isNotBlank(viewStart)){
					start = html.indexOf(viewStart);
					if (start == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.VIEWSTARTNOTFOUND);
					}
					start += viewStart.length();
					end = html.indexOf(viewEnd, start);
					if (end == -1) {
						return handerResult(temp, history, null,
								CmsAcquisition.AcquisitionResultType.VIEWENDNOTFOUND);
					}
					view = html.substring(start, end);
				}
				
				Content content = cmsAcquisitionMng.saveContent(title, txt,origin,author,description,releaseTime,
						acquId, CmsAcquisition.AcquisitionResultType.SUCCESS, temp, history,typeImg);
				if(view !=null && StringUtils.isNotBlank(view)){
					ContentCount count=content.getContentCount();
					int c=Integer.parseInt(view);
					//采集访问一次需减一
					if(StringUtils.isNotBlank(viewLink)){
						c=c-1;
					}
					count.setViews(c);
					contentCountMng.update(count);
				}
				cmsAcquisitionTempMng.save(temp);
				cmsAcquisitionHistoryMng.save(history);
				return content;
			} catch (Exception e) {
				e.printStackTrace();
				//log.warn(null, e);
				log.warn(e.getMessage());
				return handerResult(temp, history, null,
						CmsAcquisition.AcquisitionResultType.UNKNOW);
			}
		}
		/**
		 * 获取分页链接集合
		 * @param set
		 * @param start
		 * @param end
		 * @param html
		 * @param contentPageStart
		 * @param contentPageEnd
		 * @param contentPagePrefix
		 * @return
		 */
		private Set<String> getPageList(Set<String> set,int start,int end,String html,String contentPageStart,
				String contentPageEnd,String contentPagePrefix,String pageLinkStart,String pageLinkEnd){
			start = html.indexOf(contentPageStart);
			if (start == -1) {
				return set;
			}
			start += contentPageStart.length();
			end = html.indexOf(contentPageEnd, start);
			if (end == -1) {
				return set;
			}
			String s = html.substring(start, end);
			start=0;
			String link;
			while ((start = s.indexOf(pageLinkStart, start)) != -1) {
				start += pageLinkStart.length();
				end = s.indexOf(pageLinkEnd, start);
				if (end == -1) {
					return set;
				} else {
					link = s.substring(start, end);
					//内容分页地址前缀
					if(StringUtils.isNotBlank(contentPagePrefix)){
						link=contentPagePrefix+link;
					}					
					log.debug("content page link: {}", link);
					set.add(link);
					start = end + pageLinkEnd.length();
				}
			}
			return set;
		}
		
		/**
		 * 获取分页内容
		 * @param contentStart
		 * @param contentEnd
		 * @param url
		 * @param client
		 * @param handler
		 * @param httpget
		 * @param config
		 * @param site
		 * @param ftp
		 * @param oss
		 * @return
		 */
		private String getPageTxt(String contentStart,String contentEnd,String url,HttpClient client,
				CharsetHandler handler,HttpGet httpget,CmsConfig config,CmsSite site,Ftp ftp,CmsOss oss){
			String txt=null;
			try {
				int start,end;
				httpget = new HttpGet(new URI(url));
				String html = client.execute(httpget, handler);
				//批量屏蔽
				if (shields!=null) {
					for(CmsAcquisitionShield shield :shields){
						html=shieldContent(shield, html);
					}
				}	
				//批量替换
				if (replaces!=null) {
					for(CmsAcquisitionReplace replace :replaces){
						html=html.replaceAll(replace.getKeyword(), replace.getReplaceWord());
					}
				}	
				start = html.indexOf(contentStart);				
				start += contentStart.length();
				end = html.indexOf(contentEnd, start);				
				txt = html.substring(start, end);
				if(acqu.getImgAcqu()){
					List<String>imgUrls=ImageUtils.getImageSrc(txt);
					for(String img:imgUrls){
						String imgRealUrl;
						if(StringUtils.isNotBlank(acqu.getImgPrefix())){
							imgRealUrl=acqu.getImgPrefix()+img;
						}else{
							imgRealUrl=img;
						}
						String imageUrl=imgSvc.crawlImg(imgRealUrl, config.getContextPath(), 
								config.getUploadToDb(), config.getDbFileUri(), ftp,
								oss,site.getUploadPath());	
						txt=txt.replace(img, imageUrl);
					}
				}
			} catch (Exception e) {
				//log.warn(null, e);
				log.warn(e.getMessage());
			}
			return txt;
		}
		
		
		private Content handerResult(CmsAcquisitionTemp temp,
				CmsAcquisitionHistory history, String title,
				CmsAcquisition.AcquisitionResultType errorType) {
			return handerResult(temp, history, title, errorType, false);
		}

		private Content handerResult(CmsAcquisitionTemp temp,
                                     CmsAcquisitionHistory history, String title,
                                     CmsAcquisition.AcquisitionResultType errorType, Boolean repeat) {
			temp.setDescription(errorType.name());
			temp.setTitle(title);
			cmsAcquisitionTempMng.save(temp);
			if (!repeat) {
				history.setTitle(title);
				history.setDescription(errorType.name());
				cmsAcquisitionHistoryMng.save(history);
			}
			return null;
		}
	}

	private CmsAcquisitionTemp newTemp(String channelUrl, String contentUrl,
			Integer id, Float curr, Float total, CmsSite site) {
		CmsAcquisitionTemp temp = new CmsAcquisitionTemp();
		temp.setChannelUrl(channelUrl);
		temp.setContentUrl(contentUrl);
		temp.setSeq(id);
		NumberFormat nf = NumberFormat.getPercentInstance();
		String percent = nf.format(curr / total);
		temp.setPercent(Integer.parseInt(percent.substring(0,
				percent.length() - 1)));
		temp.setSite(site);
		return temp;
	}

	private CmsAcquisitionHistory newHistory(String channelUrl,
			String contentUrl, CmsAcquisition acqu) {
		CmsAcquisitionHistory history = new CmsAcquisitionHistory();
		history.setChannelUrl(channelUrl);
		history.setContentUrl(contentUrl);
		history.setAcquisition(acqu);
		return history;
	}

	private class CharsetHandler implements ResponseHandler<String> {
		private String charset;

		public CharsetHandler(String charset) {
			this.charset = charset;
		}

		public String handleResponse(HttpResponse response)
				throws ClientProtocolException, IOException {
			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() >= 300) {
				throw new HttpResponseException(statusLine.getStatusCode(),
						statusLine.getReasonPhrase());
			}
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				if (!StringUtils.isBlank(charset)) {
					return EntityUtils.toString(entity, charset);
				} else {
					return EntityUtils.toString(entity);
				}
			} else {
				return null;
			}
		}
	}
}
