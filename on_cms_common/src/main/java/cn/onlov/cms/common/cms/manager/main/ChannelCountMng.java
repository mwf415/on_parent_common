package cn.onlov.cms.common.cms.manager.main;

import cn.onlov.cms.common.cms.entity.main.Channel;
import cn.onlov.cms.common.cms.entity.main.ChannelCount;
import net.sf.ehcache.Ehcache;

/**
 * 栏目计数Manager接口
 * 
 * '栏目'数据存在则'栏目计数'数据必须存在。
 */
public interface ChannelCountMng {

	public int freshCacheToDB(Ehcache cache);

	public ChannelCount findById(Integer id);

	public ChannelCount save(ChannelCount count, Channel channel);

	public ChannelCount update(ChannelCount bean);
	
	public void afterSaveContent(Channel channel);
	
	public void afterDelContent(Channel channel);
}