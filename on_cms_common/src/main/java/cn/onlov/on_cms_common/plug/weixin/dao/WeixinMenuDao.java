package cn.onlov.on_cms_common.plug.weixin.dao;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.plug.weixin.entity.WeixinMenu;

public interface WeixinMenuDao {
	
	public Pagination getPage(Integer siteId,Integer parentId,int pageNo,int pageSize);
	
	public List<WeixinMenu> getList(Integer siteId,Integer count);
	
	public WeixinMenu findById(Integer id);
	
	public WeixinMenu save(WeixinMenu bean);

	public WeixinMenu updateByUpdater(Updater<WeixinMenu> updater);
	
	public WeixinMenu deleteById(Integer id);
}
