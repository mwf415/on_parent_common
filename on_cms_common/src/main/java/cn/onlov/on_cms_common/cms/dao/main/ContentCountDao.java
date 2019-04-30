package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import net.sf.ehcache.Ehcache;

import cn.onlov.on_cms_common.cms.entity.main.ContentCount;

public interface ContentCountDao {
	public int clearCount(boolean week, boolean month);

	public int copyCount();

	public int freshCacheToDB(Ehcache cache);

	public ContentCount findById(Integer id);

	public ContentCount save(ContentCount bean);

	public ContentCount updateByUpdater(Updater<ContentCount> updater);
}