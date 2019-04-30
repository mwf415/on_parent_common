package cn.onlov.on_cms_common.cms.dao.main;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.main.ContentCharge;

public interface ContentChargeDao {
	
	public List<ContentCharge> getList(String contentTitle,Integer authorUserId,
			Date buyTimeBegin,Date buyTimeEnd,int orderBy,Integer first,Integer count);
	
	public Pagination getPage(String contentTitle, Integer authorUserId,
                              Date buyTimeBegin, Date buyTimeEnd,
                              int orderBy, int pageNo, int pageSize);
	
	public ContentCharge findById(Integer id);

	public ContentCharge save(ContentCharge bean);

	public ContentCharge updateByUpdater(Updater<ContentCharge> updater);
}