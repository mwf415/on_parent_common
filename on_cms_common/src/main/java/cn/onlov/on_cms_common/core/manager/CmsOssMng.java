package cn.onlov.on_cms_common.core.manager;

import java.util.List;

import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsOss;

public interface CmsOssMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsOss> getList();

	public CmsOss findById(Integer id);

	public CmsOss save(CmsOss bean);

	public CmsOss update(CmsOss bean);

	public CmsOss deleteById(Integer id);
	
	public CmsOss[] deleteByIds(Integer[] ids);
}