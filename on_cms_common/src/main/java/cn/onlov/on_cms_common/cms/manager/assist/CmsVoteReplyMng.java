package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteReply;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface CmsVoteReplyMng {

	public Pagination getPage(Integer  subTopicId, int pageNo, int pageSize);
	
	public CmsVoteReply findById(Integer id);

	public CmsVoteReply save(CmsVoteReply bean);

	public CmsVoteReply update(CmsVoteReply bean);

	public CmsVoteReply deleteById(Integer id);

	public CmsVoteReply[] deleteByIds(Integer[] ids);
}