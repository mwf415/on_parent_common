package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.ApiAccount;
import cn.onlov.on_cms_common.cms.entity.main.ApiUserLogin;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsUser;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ApiUserLoginMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	/**
	 * 清除 end之前的登陆信息
	 * @param end
	 */
	public void clearByDate(Date end);
	
	public List<ApiUserLogin> getList(Date end, int first, int count);

	public ApiUserLogin findById(Long id);
	
	public ApiUserLogin findUserLogin(String username,String sessionKey);
	
	public CmsUser getUser(ApiAccount apiAccount, HttpServletRequest request);
	
	public CmsUser getUser(HttpServletRequest request);
	
	public CmsUser findUser(String sessionKey,String aesKey,String ivKey);
	
	public ApiUserLogin userLogin(String username,String appId, String sessionKey,
			HttpServletRequest request,HttpServletResponse response);
	
	public ApiUserLogin userLogout(String username,String appId, String sessionKey);
	
	public Short getUserStatus(String sessionKey);
	
	public Short getStatus(ApiAccount apiAccount,
			HttpServletRequest request,HttpServletResponse response);
	
	public void userActive(HttpServletRequest request,HttpServletResponse response);

	public ApiUserLogin save(ApiUserLogin bean);

	public ApiUserLogin update(ApiUserLogin bean);

	public ApiUserLogin deleteById(Long id);
	
	public ApiUserLogin[] deleteByIds(Long[] ids);
}