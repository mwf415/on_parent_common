package cn.onlov.on_cms_common.core.dao.impl;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.ConfigDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.Config;

@Repository
public class ConfigDaoImpl extends HibernateBaseDao<Config, String> implements
        ConfigDao {
	@SuppressWarnings("unchecked")
	public List<Config> getList() {
		String hql = "from Config";
		return find(hql);
	}

	public Config findById(String id) {
		Config entity = get(id);
		return entity;
	}

	public Config save(Config bean) {
		getSession().save(bean);
		return bean;
	}

	public Config deleteById(String id) {
		Config entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Config> getEntityClass() {
		return Config.class;
	}
}