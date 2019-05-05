package cn.onlov.cms.common.cms.manager.main;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.main.ApiInfo;

public interface ApiInfoMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiInfo findByUrl(String url);

	public ApiInfo findById(Integer id);

	public ApiInfo save(ApiInfo bean);

	public ApiInfo update(ApiInfo bean);

	public ApiInfo deleteById(Integer id);
	
	public ApiInfo[] deleteByIds(Integer[] ids);
}