package cn.onlov.on_cms_common.core.dao;

import java.util.List;

import cn.onlov.on_cms_common.core.entity.Config;

public interface ConfigDao {
	public List<Config> getList();

	public Config findById(String id);

	public Config save(Config bean);

	public Config deleteById(String id);
}