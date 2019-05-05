package cn.onlov.cms.common.core.dao;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.core.entity.DbFile;

public interface DbFileDao {
	public DbFile findById(String id);

	public DbFile save(DbFile bean);

	public DbFile updateByUpdater(Updater<DbFile> updater);

	public DbFile deleteById(String id);
}