package cn.onlov.on_cms_common.plug.store.dao.impl;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.plug.store.dao.PlugStoreConfigDao;
import cn.onlov.on_cms_common.plug.store.entity.PlugStoreConfig;

@Repository
public class PlugStoreConfigDaoImpl extends HibernateBaseDao<PlugStoreConfig, Integer> implements PlugStoreConfigDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public PlugStoreConfig findById(Integer id) {
		PlugStoreConfig entity = get(id);
		return entity;
	}

	public PlugStoreConfig save(PlugStoreConfig bean) {
		getSession().save(bean);
		return bean;
	}

	public PlugStoreConfig deleteById(Integer id) {
		PlugStoreConfig entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<PlugStoreConfig> getEntityClass() {
		return PlugStoreConfig.class;
	}
}