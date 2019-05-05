package cn.onlov.cms.common.cms.dao.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsAcquisitionShieldDao;
import cn.onlov.cms.common.common.hibernate4.Finder;
import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Component;

import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionShield;

@Component
public class CmsAcquisitionShieldDaoImpl extends HibernateBaseDao<CmsAcquisitionShield, Integer> implements CmsAcquisitionShieldDao {

	@Override
	public CmsAcquisitionShield save(CmsAcquisitionShield bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	public List<CmsAcquisitionShield> getList(Integer acquisitionId) {
		Finder f=Finder.create("from CmsAcquisitionShield bean where 1 = 1");
		if (acquisitionId!=null) {
			f.append(" and bean.acquisition.id = :acquisitionId");
			f.setParam("acquisitionId", acquisitionId);
		}
		return find(f);
	}
	
	@Override
	protected Class<CmsAcquisitionShield> getEntityClass() {
		return CmsAcquisitionShield.class;
	}


}
