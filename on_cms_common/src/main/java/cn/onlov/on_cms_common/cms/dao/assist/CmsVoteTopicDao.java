package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteTopic;

public interface CmsVoteTopicDao {
	public Pagination getPage(Integer siteId, Short statu, int pageNo, int pageSize);
	
	public List<CmsVoteTopic> getList(Boolean def,Integer siteId,Integer first, int count);

	public CmsVoteTopic getDefTopic(Integer siteId);

	public CmsVoteTopic findById(Integer id);

	public CmsVoteTopic save(CmsVoteTopic bean);

	public CmsVoteTopic updateByUpdater(Updater<CmsVoteTopic> updater);

	public CmsVoteTopic deleteById(Integer id);
}