package cn.onlov.on_cms_common.core.dao;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.entity.DbFile;

public interface DbFileDao {
	public DbFile findById(String id);

	public DbFile save(DbFile bean);

	public DbFile updateByUpdater(Updater<DbFile> updater);

	public DbFile deleteById(String id);
}