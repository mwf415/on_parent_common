package cn.onlov.cms.common.cms.dao.main;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;

import java.util.List;

import cn.onlov.cms.common.cms.entity.main.ContentBuy;

public interface ContentBuyDao {
	public Pagination getPage(String orderNum, Integer buyUserId, Integer authorUserId,
                              Short payMode, int pageNo, int pageSize);
	
	public List<ContentBuy> getList(String orderNum,Integer buyUserId,
			Integer authorUserId,Short payMode,Integer first, Integer count);
	
	public Pagination getPageByContent(Integer contentId,
			Short payMode,int pageNo, int pageSize);
	
	public List<ContentBuy> getListByContent(Integer contentId,
			Short payMode,Integer first, Integer count);

	public ContentBuy findById(Long id);
	
	public ContentBuy findByOrderNumber(String orderNumber);
	
	public ContentBuy findByOutOrderNum(String orderNum,Integer payMethod);
	
	public ContentBuy find(Integer buyUserId,Integer contentId);

	public ContentBuy save(ContentBuy bean);

	public ContentBuy updateByUpdater(Updater<ContentBuy> updater);

	public ContentBuy deleteById(Long id);
}