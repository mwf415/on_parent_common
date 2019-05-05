package cn.onlov.cms.common.cms.manager.assist;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.cms.entity.assist.CmsVoteItem;
import cn.onlov.cms.common.cms.entity.assist.CmsVoteSubTopic;
import cn.onlov.cms.common.cms.entity.assist.CmsVoteTopic;

public interface CmsVoteTopicMng {
	public Pagination getPage(Integer siteId, Short statu, int pageNo, int pageSize);
	
	public List<CmsVoteTopic> getList(Boolean def, Integer siteId,
                                      Integer first, int count);

	public CmsVoteTopic findById(Integer id);

	public CmsVoteTopic getDefTopic(Integer siteId);

	public CmsVoteTopic vote(Integer topicId,Integer[]subIds, List<Integer[]> itemIds,String[]replys, CmsUser user,
			String ip, String cookie);

	public CmsVoteTopic save(CmsVoteTopic bean, Set<CmsVoteSubTopic> subTopics, Map<Integer,Set<CmsVoteItem>>items);
	
	public CmsVoteTopic save(CmsVoteTopic bean, Set<CmsVoteSubTopic> subTopics);
	
	public CmsVoteTopic save(CmsVoteTopic bean);

	public CmsVoteTopic update(CmsVoteTopic bean);
	
	public CmsVoteTopic update(CmsVoteTopic bean, Set<CmsVoteSubTopic> subTopics,Map<Integer,Set<CmsVoteItem>>items);
	
	public void updatePriority(Integer[] id,Integer defId,Boolean[] disabled,Integer siteId);

	public CmsVoteTopic deleteById(Integer id);

	public CmsVoteTopic[] deleteByIds(Integer[] ids);
}