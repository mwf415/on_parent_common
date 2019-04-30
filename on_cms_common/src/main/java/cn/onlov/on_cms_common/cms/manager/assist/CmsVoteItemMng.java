package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.Collection;

import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteItem;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteSubTopic;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface CmsVoteItemMng {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsVoteItem findById(Integer id);

	public Collection<CmsVoteItem> save(Collection<CmsVoteItem> items,
			CmsVoteSubTopic topic);

	public Collection<CmsVoteItem> update(Collection<CmsVoteItem> items,
			CmsVoteSubTopic topic);

	public CmsVoteItem deleteById(Integer id);

	public CmsVoteItem[] deleteByIds(Integer[] ids);

}