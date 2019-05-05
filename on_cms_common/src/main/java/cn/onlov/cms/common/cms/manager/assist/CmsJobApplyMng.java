package cn.onlov.cms.common.cms.manager.assist;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsJobApply;

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