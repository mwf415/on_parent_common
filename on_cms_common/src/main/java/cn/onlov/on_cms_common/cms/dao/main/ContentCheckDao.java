package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.main.ContentCheck;

public interface ContentCheckDao {
	public ContentCheck findById(Long id);

	public ContentCheck save(ContentCheck bean);

	public ContentCheck updateByUpdater(Updater<ContentCheck> updater);
}