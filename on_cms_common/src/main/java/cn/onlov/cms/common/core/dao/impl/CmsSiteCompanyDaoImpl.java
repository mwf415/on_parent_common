package cn.onlov.cms.common.core.dao.impl;

import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import cn.onlov.cms.common.core.entity.CmsSiteCompany;
import cn.onlov.cms.common.core.dao.CmsSiteCompanyDao;
import org.springframework.stereotype.Repository;

@Repository
public class CmsSiteCompanyDaoImpl extends
        HibernateBaseDao<CmsSiteCompany, Integer> implements CmsSiteCompanyDao {

	public CmsSiteCompany save(CmsSiteCompany bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<CmsSiteCompany> getEntityClass() {
		return CmsSiteCompany.class;
	}
}