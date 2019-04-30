package cn.onlov.on_cms_common.plug.weixin.dao;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.plug.weixin.entity.Weixin;

public interface WeixinDao {
	
	public Pagination getPage(Integer siteId,int pageNo,int pageSize);
	
	public Weixin save(Weixin bean);
	
	public Weixin deleteById(Integer id);
	
	public Weixin findById(Integer id);
	
	public Weixin find(Integer siteId);

	public Weixin updateByUpdater(Updater<Weixin> updater);
}
