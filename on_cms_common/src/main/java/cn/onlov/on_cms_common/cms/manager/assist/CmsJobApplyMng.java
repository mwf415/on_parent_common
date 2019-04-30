package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsJobApply;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.List;

public interface CmsJobApplyMng {
	public Pagination getPage(Integer userId, Integer contentId, Integer siteId,
                              boolean cacheable, String title, int pageNo, int pageSize);
	
	public List<CmsJobApply> getList(Integer userId, Integer contentId, Integer siteId,
                                     boolean cacheable, String title, Integer first, Integer count);

	public CmsJobApply findById(Integer id);

	public CmsJobApply save(CmsJobApply bean);

	public CmsJobApply update(CmsJobApply bean);

	public CmsJobApply deleteById(Integer id);
	
	public CmsJobApply[] deleteByIds(Integer[] ids);
}