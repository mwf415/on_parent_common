package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsSiteAccessCountHour;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.Date;
import java.util.List;

public interface CmsSiteAccessCountHourMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsSiteAccessCountHour> getList(Date date);
	
	public void statisticCount(Date date, Integer siteId);

	public CmsSiteAccessCountHour findById(Integer id);

	public CmsSiteAccessCountHour save(CmsSiteAccessCountHour bean);
}