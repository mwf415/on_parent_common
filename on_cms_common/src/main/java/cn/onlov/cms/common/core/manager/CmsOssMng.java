package cn.onlov.cms.common.core.manager;

import java.util.List;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.CmsOss;

public interface CmsOssMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsOss> getList();

	public CmsOss findById(Integer id);

	public CmsOss save(CmsOss bean);

	public CmsOss update(CmsOss bean);

	public CmsOss deleteById(Integer id);
	
	public CmsOss[] deleteByIds(Integer[] ids);
}