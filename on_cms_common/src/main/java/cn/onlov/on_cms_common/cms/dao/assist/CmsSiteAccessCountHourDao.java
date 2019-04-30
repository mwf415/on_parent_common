package cn.onlov.on_cms_common.cms.dao.assist;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsSiteAccessCountHour;

public interface CmsSiteAccessCountHourDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsSiteAccessCountHour> getList(Date date);

	public CmsSiteAccessCountHour findById(Integer id);

	public CmsSiteAccessCountHour save(CmsSiteAccessCountHour bean);

	public CmsSiteAccessCountHour updateByUpdater(Updater<CmsSiteAccessCountHour> updater);

	public CmsSiteAccessCountHour deleteById(Integer id);
}