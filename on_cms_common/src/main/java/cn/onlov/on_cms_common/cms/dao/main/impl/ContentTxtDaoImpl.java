package cn.onlov.on_cms_common.cms.dao.main.impl;

import cn.onlov.on_cms_common.cms.dao.main.ContentTxtDao;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.main.ContentTxt;

@Repository
public class ContentTxtDaoImpl extends HibernateBaseDao<ContentTxt, Integer>
		implements ContentTxtDao {
	public ContentTxt findById(Integer id) {
		ContentTxt entity = get(id);
		return entity;
	}

	public ContentTxt save(ContentTxt bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<ContentTxt> getEntityClass() {
		return ContentTxt.class;
	}
}