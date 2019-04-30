package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsScoreItem;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface CmsScoreItemMng {
	public Pagination getPage(Integer groupId, int pageNo, int pageSize);

	public CmsScoreItem findById(Integer id);

	public CmsScoreItem save(CmsScoreItem bean);

	public CmsScoreItem update(CmsScoreItem bean);

	public CmsScoreItem deleteById(Integer id);
	
	public CmsScoreItem[] deleteByIds(Integer[] ids);
}