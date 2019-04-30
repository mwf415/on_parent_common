package cn.onlov.on_cms_common.cms.task.job;

import cn.onlov.on_cms_common.cms.entity.assist.CmsTask;
import cn.onlov.on_cms_common.cms.staticpage.StaticPageSvc;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;

/**
 * @Description 內容页面静态化的job类
 * @author tom
 */
public class ContentStaticJob extends QuartzJobBean {
	private static final Logger log = LoggerFactory.getLogger(ContentStaticJob.class);
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
				try {
					SchedulerContext schCtx = context.getScheduler().getContext();
					// 获取Spring中的上下文
					ApplicationContext appCtx = (ApplicationContext) schCtx.get("applicationContext");
					this.staticPageSvc = (StaticPageSvc) appCtx.getBean("staticPageSvc");
					JobDataMap jdm=context.getJobDetail().getJobDataMap();
					//获取栏目
			        String channelIdStr=(String) jdm.get(CmsTask.TASK_PARAM_CHANNEL_ID);
			        if(!StringUtils.isBlank(channelIdStr)){
			        	this.channelId=Integer.parseInt(channelIdStr);
			        	if(channelId.equals(0)){
			        		channelId=null;
			        	}
			        }
					//获取站点
			        String siteIdStr=(String) jdm.get(CmsTask.TASK_PARAM_SITE_ID);
			        if(!StringUtils.isBlank(siteIdStr)){
			        	this.siteId=Integer.parseInt(siteIdStr);
			        }
				} catch (SchedulerException e1) {
					// TODO 尚未处理异常
					e1.printStackTrace();
				}
				staticContent();
	}
	
	public void staticContent() {
		log.info("static content page");
		try {
			staticPageSvc.content(null, null, siteId, channelId, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private StaticPageSvc staticPageSvc;
	private Integer channelId;
	private Integer siteId;
}
