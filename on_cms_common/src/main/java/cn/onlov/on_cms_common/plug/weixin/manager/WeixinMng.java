package cn.onlov.on_cms_common.plug.weixin.manager;

import cn.onlov.on_cms_common.plug.weixin.entity.Weixin;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface WeixinMng {

	public Pagination getPage(Integer siteId,int pageNo,int pageSize);
	
	public Weixin findById(Integer id);
	
	public Weixin find(Integer siteId);
	
	public Weixin save(Weixin bean);
	
	public Weixin update(Weixin bean);
	
	public Weixin deleteById(Integer id);
	
	public Weixin[] delete(Integer[] id);
}
