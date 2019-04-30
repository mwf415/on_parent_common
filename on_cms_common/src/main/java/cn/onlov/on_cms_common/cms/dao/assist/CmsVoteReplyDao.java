package cn.onlov.on_cms_common.cms.dao.assist;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteReply;

public interface CmsVoteReplyDao {

	public Pagination getPage(Integer  subTopicId, int pageNo, int pageSize);
	
	public CmsVoteReply findById(Integer id);

	public CmsVoteReply save(CmsVoteReply bean);

	public CmsVoteReply updateByUpdater(Updater<CmsVoteReply> updater);

	public CmsVoteReply deleteById(Integer id);
}