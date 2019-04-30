package cn.onlov.on_cms_common.plug.weixin.manager;

import java.util.List;

import cn.onlov.on_cms_common.plug.weixin.entity.WeixinMenu;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface WeixinMenuMng {
	
	public Pagination getPage(Integer siteId,Integer parentId
			,int pageNo,int pageSize);
	
	public List<WeixinMenu> getList(Integer siteId, Integer count);
	
	public String getMenuJsonString(Integer siteId);
	
	public WeixinMenu findById(Integer id);
	
	public WeixinMenu save(WeixinMenu bean);
	
	public WeixinMenu update(WeixinMenu bean);
	
	public WeixinMenu deleteById(Integer id);
	
	public WeixinMenu[] deleteByIds(Integer[] ids);
}
