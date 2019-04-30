package cn.onlov.on_cms_common.core.manager;

import java.util.List;

import cn.onlov.on_cms_common.core.entity.CmsConfigItem;

public interface CmsConfigItemMng {
	public List<CmsConfigItem> getList(Integer configId, Integer category);

	public CmsConfigItem findById(Integer id);

	public CmsConfigItem save(CmsConfigItem bean);

	public void saveList(List<CmsConfigItem> list);

	public void updatePriority(Integer[] wids, Integer[] priority,String[] label);

	public CmsConfigItem update(CmsConfigItem bean);

	public CmsConfigItem deleteById(Integer id);

	public CmsConfigItem[] deleteByIds(Integer[] ids);
}