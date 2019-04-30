package cn.onlov.on_cms_common.cms.dao.main;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.main.CmsModelItem;

public interface CmsModelItemDao {
	public List<CmsModelItem> getList(Integer modelId, boolean isChannel,
			Boolean hasDisabled);

	public CmsModelItem findById(Integer id);

	public CmsModelItem save(CmsModelItem bean);

	public CmsModelItem updateByUpdater(Updater<CmsModelItem> updater);

	public CmsModelItem deleteById(Integer id);
}