package cn.onlov.on_cms_common.cms.service;

import javax.servlet.http.HttpServletRequest;

/**
 * 站点流量缓存接口
 */
public interface CmsSiteFlowCache {
	public Long[]  flow(HttpServletRequest request, String page,String referrer);
}
