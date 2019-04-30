package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import net.sf.ehcache.Ehcache;

import cn.onlov.on_cms_common.cms.entity.main.ChannelCount;

public interface ChannelCountDao {
	public int clearCount(boolean week, boolean month);
	
	public int clearContentCount(boolean day,boolean week, boolean month,boolean year);

	public int freshCacheToDB(Ehcache cache);

	public ChannelCount findById(Integer id);

	public ChannelCount save(ChannelCount bean);

	public ChannelCount updateByUpdater(Updater<ChannelCount> updater);
}