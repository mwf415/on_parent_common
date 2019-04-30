package cn.onlov.on_cms_common.cms.dao.assist.impl;

import java.util.List;

import cn.onlov.on_cms_common.cms.dao.assist.CmsVoteSubTopicDao;
import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteSubTopic;

@Repository
public class CmsVoteSubTopicDaoImpl extends
        HibernateBaseDao<CmsVoteSubTopic, Integer> implements CmsVoteSubTopicDao {
	
	@SuppressWarnings("unchecked")
	public List<CmsVoteSubTopic> findByVoteTopic(Integer voteTopicId){
		String hql="select bean from CmsVoteSubTopic bean";
		Finder finder=Finder.create(hql);
		if(voteTopicId!=null){
			finder.append(" where bean.voteTopic.id=:voteTopicId").setParam("voteTopicId", voteTopicId);
		}
		finder.append(" order by  bean.priority asc,bean.id desc");
		finder.setCacheable(true);
		return find(finder);
	}
	
	public CmsVoteSubTopic findById(Integer id) {
		CmsVoteSubTopic entity = get(id);
		return entity;
	}

	public CmsVoteSubTopic save(CmsVoteSubTopic bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsVoteSubTopic deleteById(Integer id) {
		CmsVoteSubTopic entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsVoteSubTopic> getEntityClass() {
		return CmsVoteSubTopic.class;
	}
}