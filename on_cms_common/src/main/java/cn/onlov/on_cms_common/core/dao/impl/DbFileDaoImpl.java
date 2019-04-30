package cn.onlov.on_cms_common.core.dao.impl;

import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.DbFileDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.DbFile;

@Repository
public class DbFileDaoImpl extends HibernateBaseDao<DbFile, String> implements
        DbFileDao {
	public DbFile findById(String id) {
		DbFile entity = get(id);
		return entity;
	}

	public DbFile save(DbFile bean) {
		getSession().save(bean);
		return bean;
	}

	public DbFile deleteById(String id) {
		DbFile entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<DbFile> getEntityClass() {
		return DbFile.class;
	}
}