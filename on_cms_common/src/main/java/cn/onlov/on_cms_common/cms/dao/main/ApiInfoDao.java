package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.main.ApiInfo;

public interface ApiInfoDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiInfo findByUrl(String url);

	public ApiInfo findById(Integer id);

	public ApiInfo save(ApiInfo bean);

	public ApiInfo updateByUpdater(Updater<ApiInfo> updater);

	public ApiInfo deleteById(Integer id);
}