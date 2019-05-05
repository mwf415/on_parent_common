package cn.onlov.cms.common.cms.staticpage;

import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.cms.entity.main.Channel;
import cn.onlov.cms.common.cms.entity.main.Content;
import freemarker.template.TemplateException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public interface StaticPageSvc {
	public int content(HttpServletRequest request, HttpServletResponse response, Integer siteId, Integer channelId, Date start)
			throws IOException, TemplateException;

	public boolean content(Content content) throws IOException, TemplateException;

	public void contentRelated(Content content) throws IOException,
			TemplateException;
	
	public void contentRelated(Integer contentId) throws IOException,
	TemplateException;

	public void deleteContent(Content content) throws IOException, TemplateException;

	public int channel(HttpServletRequest request, HttpServletResponse response, Integer siteId, Integer channelId, boolean containChild)
			throws IOException, TemplateException;

	public void channel(Channel channel, boolean firstOnly) throws IOException,
			TemplateException;

	public void deleteChannel(Channel channel);
	
	public void index(Integer siteId) throws IOException, TemplateException;

	public void index(CmsSite site) throws IOException, TemplateException;

	public void index(CmsSite site, String tpl, Map<String, Object> data, boolean mobile)
			throws IOException, TemplateException;

	public boolean deleteIndex(CmsSite site);
}
