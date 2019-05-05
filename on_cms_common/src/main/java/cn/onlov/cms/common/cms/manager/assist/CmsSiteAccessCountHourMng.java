package cn.onlov.cms.common.cms.manager.assist;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsSiteAccessCountHour;

import java.util.Date;
import java.util.List;

public interface CmsSiteAccessCountHourMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsSiteAccessCountHour> getList(Date date);
	
	public void statisticCount(Date date, Integer siteId);

	public CmsSiteAccessCountHour findById(Integer id);

	public CmsSiteAccessCountHour save(CmsSiteAccessCountHour bean);
}