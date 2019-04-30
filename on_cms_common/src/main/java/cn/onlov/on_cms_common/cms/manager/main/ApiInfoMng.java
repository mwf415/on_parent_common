package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.ApiInfo;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface ApiInfoMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiInfo findByUrl(String url);

	public ApiInfo findById(Integer id);

	public ApiInfo save(ApiInfo bean);

	public ApiInfo update(ApiInfo bean);

	public ApiInfo deleteById(Integer id);
	
	public ApiInfo[] deleteByIds(Integer[] ids);
}