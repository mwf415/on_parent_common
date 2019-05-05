package cn.onlov.cms.common.cms.dao.main;

import cn.onlov.cms.common.common.hibernate4.Updater;
import net.sf.ehcache.Ehcache;

import cn.onlov.cms.common.cms.entity.main.ContentCount;

public interface ContentCountDao {
	public int clearCount(boolean week, boolean month);

	public int copyCount();

	public int freshCacheToDB(Ehcache cache);

	public ContentCount findById(Integer id);

	public ContentCount save(ContentCount bean);

	public ContentCount updateByUpdater(Updater<ContentCount> updater);
}