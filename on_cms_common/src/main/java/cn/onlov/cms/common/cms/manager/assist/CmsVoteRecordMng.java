package cn.onlov.cms.common.cms.manager.assist;

import java.util.Date;

import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.cms.entity.assist.CmsVoteRecord;
import cn.onlov.cms.common.cms.entity.assist.CmsVoteTopic;

public interface CmsVoteRecordMng {
	public CmsVoteRecord save(CmsVoteTopic topic, CmsUser user, String ip,
                              String cookie);

	public int deleteByTopic(Integer topicId);

	public Date lastVoteTimeByUserId(Integer userId, Integer topicId);

	public Date lastVoteTimeByIp(String ip, Integer topicId);

	public Date lastVoteTimeByCookie(String cookie, Integer topicId);
}