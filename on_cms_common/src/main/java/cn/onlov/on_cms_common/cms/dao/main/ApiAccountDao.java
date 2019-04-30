package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.main.ApiAccount;

public interface ApiAccountDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<ApiAccount> getList(int first, int count);
	
	public ApiAccount findByAppId(String appId);
	
	public ApiAccount findAdmin();

	public ApiAccount findById(Integer id);

	public ApiAccount save(ApiAccount bean);

	public ApiAccount updateByUpdater(Updater<ApiAccount> updater);

	public ApiAccount deleteById(Integer id);
}