package cn.onlov.cms.common.plug.weixin.manager;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.plug.weixin.entity.Weixin;

public interface WeixinMng {

	public Pagination getPage(Integer siteId, int pageNo, int pageSize);
	
	public Weixin findById(Integer id);
	
	public Weixin find(Integer siteId);
	
	public Weixin save(Weixin bean);
	
	public Weixin update(Weixin bean);
	
	public Weixin deleteById(Integer id);
	
	public Weixin[] delete(Integer[] id);
}
