package cn.onlov.on_cms_common.cms.dao.main;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.main.ContentType;

public interface ContentTypeDao {
	public List<ContentType> getList(Boolean containDisabled);

	public ContentType getDef();

	public ContentType findById(Integer id);

	public ContentType save(ContentType bean);

	public ContentType updateByUpdater(Updater<ContentType> updater);

	public ContentType deleteById(Integer id);
}