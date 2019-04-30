package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsDirectiveTpl;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface CmsDirectiveTplMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsDirectiveTpl> getList(int count);

	public CmsDirectiveTpl findById(Integer id);

	public CmsDirectiveTpl save(CmsDirectiveTpl bean);

	public CmsDirectiveTpl update(CmsDirectiveTpl bean);

	public CmsDirectiveTpl deleteById(Integer id);
	
	public CmsDirectiveTpl[] deleteByIds(Integer[] ids);
}