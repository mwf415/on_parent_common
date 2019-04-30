package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.ContentBuy;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.List;

public interface ContentBuyMng {
	
	public ContentBuy contentOrder(Integer contentId, Integer orderType,
                                   Short chargeReward, Integer buyUserId, String outOrderNum);
	
	public Pagination getPage(String orderNum, Integer buyUserId, Integer authorUserId
			, Short payMode, int pageNo, int pageSize);
	
	public List<ContentBuy> getList(String orderNum,Integer buyUserId,
			Integer authorUserId,Short payMode,Integer first, Integer count);
	
	public Pagination getPageByContent(Integer contentId,
			Short payMode,int pageNo, int pageSize);
	
	public List<ContentBuy> getListByContent(Integer contentId,
			Short payMode,Integer first, Integer count);

	public ContentBuy findById(Long id);
	
	public ContentBuy findByOrderNumber(String orderNumber);
	
	public ContentBuy findByOutOrderNum(String orderNum,Integer payMethod);
	
	public boolean hasBuyContent(Integer buyUserId,Integer contentId);

	public ContentBuy save(ContentBuy bean);

	public ContentBuy update(ContentBuy bean);

	public ContentBuy deleteById(Long id);
	
	public ContentBuy[] deleteByIds(Long[] ids);
}