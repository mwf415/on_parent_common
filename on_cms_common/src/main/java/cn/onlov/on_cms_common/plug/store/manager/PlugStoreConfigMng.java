package cn.onlov.on_cms_common.plug.store.manager;

import cn.onlov.on_cms_common.plug.store.entity.PlugStoreConfig;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface PlugStoreConfigMng {
	public Pagination getPage(int pageNo, int pageSize);

	public PlugStoreConfig findById(Integer id);
	
	public PlugStoreConfig getDefault();

	public PlugStoreConfig save(PlugStoreConfig bean);

	public PlugStoreConfig update(PlugStoreConfig bean, String password);

	public PlugStoreConfig deleteById(Integer id);
	
	public PlugStoreConfig[] deleteByIds(Integer[] ids);
}