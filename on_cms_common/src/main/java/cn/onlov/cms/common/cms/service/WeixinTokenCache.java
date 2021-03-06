package cn.onlov.cms.common.cms.service;

import java.util.Map;

/**
 * 微信Token缓存接口
 */
public interface WeixinTokenCache {
	/**
	 * 获取token
	 * @return
	 */
	public Map<String, String> getToken();
}
