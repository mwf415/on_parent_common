package cn.onlov.cms.common.cms.dao.assist.impl;

import cn.onlov.cms.common.cms.dao.assist.CmsScoreGroupDao;
import cn.onlov.cms.common.common.hibernate4.Finder;
import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import cn.onlov.cms.common.common.page.Pagination;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.onlov.cms.common.cms.entity.assist.CmsScoreGroup;

@Repository
public class CmsScoreGroupDaoImpl extends HibernateBaseDao<CmsScoreGroup, Integer> implements CmsScoreGroupDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public CmsScoreGroup findById(Integer id) {
		CmsScoreGroup entity = get(id);
		return entity;
	}
	
	public CmsScoreGroup findDefault(Integer siteId){
		Finder f = Finder.create("from CmsScoreGroup bean where 1=1");
		if (siteId != null) {
			f.append(" and bean.site.id=:siteId");
			f.setParam("siteId", siteId);
		}
		f.append(" and bean.def=true");
		f.setMaxResults(1);
		return (CmsScoreGroup) f.createQuery(getSession()).uniqueResult();
	}

	public CmsScoreGroup save(CmsScoreGroup bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsScoreGroup deleteById(Integer id) {
		CmsScoreGroup entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CmsScoreGroup> getEntityClass() {
		return CmsScoreGroup.class;
	}
}