package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.Date;

import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteRecord;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteTopic;
import cn.onlov.on_cms_common.core.entity.CmsUser;

public interface CmsVoteRecordMng {
	public CmsVoteRecord save(CmsVoteTopic topic, CmsUser user, String ip,
                              String cookie);

	public int deleteByTopic(Integer topicId);

	public Date lastVoteTimeByUserId(Integer userId, Integer topicId);

	public Date lastVoteTimeByIp(String ip, Integer topicId);

	public Date lastVoteTimeByCookie(String cookie, Integer topicId);
}