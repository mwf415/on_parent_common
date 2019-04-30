package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.ApiAccount;
import cn.onlov.on_cms_common.common.page.Pagination;

import javax.servlet.http.HttpServletRequest;

public interface ApiAccountMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiAccount getApiAccount(HttpServletRequest request);
	
	public ApiAccount findByDefault();
	
	public ApiAccount findByAppId(String appId);

	public ApiAccount findById(Integer id);

	public ApiAccount save(ApiAccount bean);

	public ApiAccount update(ApiAccount bean,String appKey,String aesKey,String ivKey);

	public ApiAccount deleteById(Integer id);
	
	public ApiAccount[] deleteByIds(Integer[] ids);
}