package cn.onlov.cms.common.core.dao.impl;

import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import cn.onlov.cms.common.core.entity.DbFile;
import cn.onlov.cms.common.core.dao.DbFileDao;
import org.springframework.stereotype.Repository;

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