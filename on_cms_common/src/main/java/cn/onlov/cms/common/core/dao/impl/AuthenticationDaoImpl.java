package cn.onlov.cms.common.core.dao.impl;

import java.util.Date;

import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.Authentication;
import cn.onlov.cms.common.core.dao.AuthenticationDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDaoImpl extends
        HibernateBaseDao<Authentication, String> implements AuthenticationDao {
	public int deleteExpire(Date d) {
		String hql = "delete Authentication bean where bean.updateTime <= :d";
		return getSession().createQuery(hql).setTimestamp("d", d)
				.executeUpdate();
	}

	public Authentication getByUserId(Long userId) {
		String hql = "from Authentication bean where bean.uid=?";
		return (Authentication) findUnique(hql, userId);
	}

	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public Authentication findById(String id) {
		Authentication entity = get(id);
		return entity;
	}

	public Authentication save(Authentication bean) {
		getSession().save(bean);
		return bean;
	}

	public Authentication deleteById(String id) {
		Authentication entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Authentication> getEntityClass() {
		return Authentication.class;
	}
}