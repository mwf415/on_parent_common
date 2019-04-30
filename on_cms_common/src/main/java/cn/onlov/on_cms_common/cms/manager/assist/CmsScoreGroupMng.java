package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsScoreGroup;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface CmsScoreGroupMng {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsScoreGroup findById(Integer id);
	
	public CmsScoreGroup findDefault(Integer siteId);

	public CmsScoreGroup save(CmsScoreGroup bean);

	public CmsScoreGroup update(CmsScoreGroup bean);

	public CmsScoreGroup deleteById(Integer id);
	
	public CmsScoreGroup[] deleteByIds(Integer[] ids);
}