package cn.onlov.on_cms_common.core.dao.impl;

import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.CmsConfigDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.CmsConfig;

@Repository
public class CmsConfigDaoImpl extends HibernateBaseDao<CmsConfig, Integer>
		implements CmsConfigDao {
	public CmsConfig findById(Integer id) {
		CmsConfig entity = get(id);
		return entity;
	}

	@Override
	protected Class<CmsConfig> getEntityClass() {
		return CmsConfig.class;
	}
}