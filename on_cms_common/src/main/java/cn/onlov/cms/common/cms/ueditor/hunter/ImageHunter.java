package cn.onlov.cms.common.cms.ueditor.hunter;

import cn.onlov.cms.common.cms.ueditor.define.BaseState;
import cn.onlov.cms.common.cms.ueditor.define.State;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.cms.service.ImageSvc;
import cn.onlov.cms.common.cms.ueditor.define.MultiState;

import java.util.List;

/**
 * 图片抓取器
 *
 */
public class ImageHunter {

	private String filename = null;
	private String savePath = null;
	private String rootPath = null;
	private List<String> allowTypes = null;
	private long maxSize = -1;
	
	private List<String> filters = null;
	
	private ImageSvc imgSvc;
	private CmsSite site;
	
	public ImageHunter(ImageSvc imgSvc,CmsSite site) {
		super();
		this.imgSvc = imgSvc;
		this.site=site;
	}

	public State capture (String[] list ) {
		
		MultiState state = new MultiState( true );
		if(list!=null&&list.length>0){
			for ( String source : list ) {
				state.addState( captureRemoteData( source ) );
			}
		}
		
		return state;
		
	}
	
	public State captureByApi ( String urlPrefix,String[] list ) {
		
		MultiState state = new MultiState( true );
		if(list!=null&&list.length>0){
			for ( String source : list ) {
				state.addState( captureRemoteDataByApi( urlPrefix,source ) );
			}
		}
		
		return state;
		
	}


	public State captureRemoteData ( String urlStr ) {
		String imgUrl=imgSvc.crawlImg(urlStr, this.site);
		State state = new BaseState();
		state.putInfo( "url", imgUrl);
		state.putInfo( "source", urlStr );
		return state;
	}
	
	public State captureRemoteDataByApi (String urlPrefix, String urlStr ) {
		String imgUrl=imgSvc.crawlImg(urlStr, this.site);
		State state = new BaseState();
		state.putInfo( "url", urlPrefix+imgUrl);
		state.putInfo( "source", urlStr );
		return state;
	}
	
//	private String getPath ( String savePath, String filename, String suffix  ) {
//		
//		return PathFormat.parse( savePath + suffix, filename );
//		
//	}
	
//	private boolean validHost ( String hostname ) {
//		try {
//			InetAddress ip = InetAddress.getByName(hostname);
//			
//			if (ip.isSiteLocalAddress()) {
//				return false;
//			}
//		} catch (UnknownHostException e) {
//			return false;
//		}
//		
//		return !filters.contains( hostname );
//		
//	}
	
//	private boolean validContentState ( int code ) {
//		
//		return HttpURLConnection.HTTP_OK == code;
//		
//	}
//	
//	private boolean validFileType ( String type ) {
//		
//		return this.allowTypes.contains( type );
//		
//	}
//	
//	private boolean validFileSize ( int size ) {
//		return size < this.maxSize;
//	}
	
}
