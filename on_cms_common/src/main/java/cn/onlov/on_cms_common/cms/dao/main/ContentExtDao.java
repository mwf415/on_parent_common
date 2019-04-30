package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.main.ContentExt;

public interface ContentExtDao {
	public ContentExt findById(Integer id);

	public ContentExt save(ContentExt bean);

	public ContentExt updateByUpdater(Updater<ContentExt> updater);
}