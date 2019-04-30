package cn.onlov.on_cms_common.plug.store.dao;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.plug.store.entity.PlugStoreConfig;

public interface PlugStoreConfigDao {
	public Pagination getPage(int pageNo, int pageSize);

	public PlugStoreConfig findById(Integer id);

	public PlugStoreConfig save(PlugStoreConfig bean);

	public PlugStoreConfig updateByUpdater(Updater<PlugStoreConfig> updater);

	public PlugStoreConfig deleteById(Integer id);
}