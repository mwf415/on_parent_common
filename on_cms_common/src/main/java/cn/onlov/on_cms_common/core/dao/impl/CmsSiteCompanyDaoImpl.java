package cn.onlov.on_cms_common.core.dao.impl;

import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.CmsSiteCompanyDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.CmsSiteCompany;

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