package cn.onlov.cms.common.cms.dao.assist;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;

import java.util.Date;
import java.util.List;

import cn.onlov.cms.common.cms.entity.assist.CmsSiteAccessCountHour;

public interface CmsSiteAccessCountHourDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsSiteAccessCountHour> getList(Date date);

	public CmsSiteAccessCountHour findById(Integer id);

	public CmsSiteAccessCountHour save(CmsSiteAccessCountHour bean);

	public CmsSiteAccessCountHour updateByUpdater(Updater<CmsSiteAccessCountHour> updater);

	public CmsSiteAccessCountHour deleteById(Integer id);
}