package cn.onlov.cms.common.cms.dao.assist.impl;

import cn.onlov.cms.common.cms.dao.assist.CmsGuestbookExtDao;
import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.cms.common.cms.entity.assist.CmsGuestbookExt;

@Repository
public class CmsGuestbookExtDaoImpl extends
        HibernateBaseDao<CmsGuestbookExt, Integer> implements
        CmsGuestbookExtDao {

	public CmsGuestbookExt findById(Integer id) {
		CmsGuestbookExt entity = get(id);
		return entity;
	}

	public CmsGuestbookExt save(CmsGuestbookExt bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsGuestbookExt deleteById(Integer id) {
		CmsGuestbookExt entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsGuestbookExt> getEntityClass() {
		return CmsGuestbookExt.class;
	}
}