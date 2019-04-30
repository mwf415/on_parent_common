package cn.onlov.on_cms_common.cms.dao.main.impl;

import cn.onlov.on_cms_common.cms.dao.main.ContentCheckDao;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.main.ContentCheck;

@Repository
public class ContentCheckDaoImpl extends HibernateBaseDao<ContentCheck, Long>
		implements ContentCheckDao {
	public ContentCheck findById(Long id) {
		ContentCheck entity = get(id);
		return entity;
	}

	public ContentCheck save(ContentCheck bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<ContentCheck> getEntityClass() {
		return ContentCheck.class;
	}
}