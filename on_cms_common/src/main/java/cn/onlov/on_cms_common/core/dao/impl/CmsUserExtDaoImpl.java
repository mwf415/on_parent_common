package cn.onlov.on_cms_common.core.dao.impl;

import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.CmsUserExtDao;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.CmsUserExt;

@Repository
public class CmsUserExtDaoImpl extends HibernateBaseDao<CmsUserExt, Integer> implements CmsUserExtDao {
	public CmsUserExt findById(Integer id) {
		CmsUserExt entity = get(id);
		return entity;
	}

	public CmsUserExt save(CmsUserExt bean) {
		getSession().save(bean);
		return bean;
	}
	
	@Override
	protected Class<CmsUserExt> getEntityClass() {
		return CmsUserExt.class;
	}
	
	public void clearDayCount(){
		String hql="update CmsUserExt ext set ext.todayGuestbookTotal=0,ext.todayCommentTotal=0";
		getSession().createQuery(hql).executeUpdate();
	}
	@Override
	public int countByPhone(String mobile) {
		String hql = "select count(*) from CmsUserExt bean where bean.mobile = :mobile";
		Query query = getSession().createQuery(hql);
		query.setParameter("mobile", mobile);
		return ((Number)query.iterate().next()).intValue();
	}
}