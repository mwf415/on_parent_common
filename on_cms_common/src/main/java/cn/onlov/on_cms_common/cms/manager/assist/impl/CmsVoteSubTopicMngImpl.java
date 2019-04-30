package cn.onlov.on_cms_common.cms.manager.assist.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.onlov.on_cms_common.cms.dao.assist.CmsVoteSubTopicDao;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteItem;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteSubTopic;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteTopic;
import cn.onlov.on_cms_common.cms.manager.assist.CmsVoteItemMng;
import cn.onlov.on_cms_common.cms.manager.assist.CmsVoteSubTopicMng;
import cn.onlov.on_cms_common.common.hibernate4.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsVoteSubTopicMngImpl implements CmsVoteSubTopicMng {
	@Transactional(readOnly = true)
	public List<CmsVoteSubTopic> findByVoteTopic(Integer voteTopicId){
		return dao.findByVoteTopic(voteTopicId);
	}
	
	@Transactional(readOnly = true)
	public CmsVoteSubTopic findById(Integer id) {
		CmsVoteSubTopic entity = dao.findById(id);
		return entity;
	}

	public CmsVoteSubTopic save(CmsVoteSubTopic bean, List<CmsVoteItem> items) {
		int totalCount = 0;
		for (CmsVoteItem item : items) {
			if (item.getVoteCount() != null) {
				totalCount += item.getVoteCount();
			}
		}
		dao.save(bean);
		cmsVoteItemMng.save(items, bean);
		return bean;
	}
	
	public CmsVoteTopic save(CmsVoteTopic bean, Set<CmsVoteSubTopic> subTopics) {
		for (CmsVoteSubTopic sub : subTopics) {
			sub.setVoteTopic(bean);
			dao.save(sub);
		}
		return bean;
	}
	
	@Override
	public CmsVoteSubTopic save(CmsVoteSubTopic bean) {
		return dao.save(bean);
	}
	
	public CmsVoteSubTopic update(CmsVoteSubTopic bean, Collection<CmsVoteItem> items) {
		Updater<CmsVoteSubTopic> updater = new Updater<CmsVoteSubTopic>(bean);
		bean = dao.updateByUpdater(updater);
		int totalCount = 0;
		for (CmsVoteItem item : items) {
			totalCount += item.getVoteCount();
		}
		cmsVoteItemMng.update(items, bean);
		return bean;
	}
	
	public CmsVoteTopic update(CmsVoteTopic bean, Collection<CmsVoteSubTopic> subTopics) {
		for (CmsVoteSubTopic sub : subTopics) {
			Updater<CmsVoteSubTopic> updater = new Updater<CmsVoteSubTopic>(sub);
			dao.updateByUpdater(updater);
		}
		return bean;
	}
	public Collection<CmsVoteSubTopic> update(Collection<CmsVoteSubTopic> subTopics,
			CmsVoteTopic topic) {
		Set<CmsVoteSubTopic> set = topic.getSubtopics();
		// 先删除
		set.clear();
		Set<CmsVoteSubTopic> toAdd = new HashSet<CmsVoteSubTopic>();
		for (CmsVoteSubTopic item : subTopics) {
			// 增加
			toAdd.add(item);
		}
		save(topic,toAdd);
		set.addAll(toAdd);
		return set;
		/*
		Set<CmsVoteSubTopic> set = topic.getSubtopics();
		// 先删除
		Set<CmsVoteSubTopic> toDel = new HashSet<CmsVoteSubTopic>();
		for (CmsVoteSubTopic s : set) {
			boolean changed=true;
			for(CmsVoteSubTopic newSub:subTopics){
				if(s.getTitle().equals(newSub.getTitle())){
					changed=false;
				}
			}
			//标题改变则清除
			if(changed){
				toDel.add(s);
			}
		}
		set.removeAll(toDel);
		// 再更新和增加
		Updater<CmsVoteSubTopic> updater;
		Set<CmsVoteSubTopic> toAdd = new HashSet<CmsVoteSubTopic>();
		for (CmsVoteSubTopic item : subTopics) {
			if (set.contains(item)) {
				// 更新
				updater = new Updater<CmsVoteSubTopic>(item);
				dao.updateByUpdater(updater);
			} else {
				// 增加
				toAdd.add(item);
			}
		}
		save(topic,toAdd);
		set.addAll(toAdd);
		return set;
		*/
	}
	
	public CmsVoteSubTopic deleteById(Integer id) {
		CmsVoteSubTopic bean = dao.deleteById(id);
		return bean;
	}

	public CmsVoteSubTopic[] deleteByIds(Integer[] ids) {
		CmsVoteSubTopic[] beans = new CmsVoteSubTopic[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsVoteItemMng cmsVoteItemMng;
	private CmsVoteSubTopicDao dao;

	@Autowired
	public void setCmsVoteItemMng(CmsVoteItemMng cmsVoteItemMng) {
		this.cmsVoteItemMng = cmsVoteItemMng;
	}
	
	@Autowired
	public void setDao(CmsVoteSubTopicDao dao) {
		this.dao = dao;
	}

}