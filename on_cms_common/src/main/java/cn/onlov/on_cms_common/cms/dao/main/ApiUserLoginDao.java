package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.cms.entity.main.ApiUserLogin;

public interface ApiUserLoginDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public void clearByDate(Date end);
	
	public List<ApiUserLogin> getList(Date end,int first, int count);

	public ApiUserLogin findById(Long id);
	
	public ApiUserLogin findUserLogin(String username,String sessionKey);

	public ApiUserLogin save(ApiUserLogin bean);

	public ApiUserLogin updateByUpdater(Updater<ApiUserLogin> updater);

	public ApiUserLogin deleteById(Long id);
}