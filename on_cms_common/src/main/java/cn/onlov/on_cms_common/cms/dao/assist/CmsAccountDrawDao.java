package cn.onlov.on_cms_common.cms.dao.assist;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsAccountDraw;

public interface CmsAccountDrawDao {
	public Pagination getPage(Integer userId, Short applyStatus,
                              Date applyTimeBegin, Date applyTimeEnd, int pageNo, int pageSize);
	
	public List<CmsAccountDraw> getList(Integer userId,Short applyStatus,
			Date applyTimeBegin,Date applyTimeEnd,Integer first,Integer count);
	
	public List<CmsAccountDraw> getList(Integer userId,Short[] status,Integer count);

	public CmsAccountDraw findById(Integer id);

	public CmsAccountDraw save(CmsAccountDraw bean);

	public CmsAccountDraw updateByUpdater(Updater<CmsAccountDraw> updater);

	public CmsAccountDraw deleteById(Integer id);
}