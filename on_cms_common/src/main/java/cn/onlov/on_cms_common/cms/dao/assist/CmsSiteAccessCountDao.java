package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.assist.CmsSiteAccessCount;

/**
 * @author Tom
 */
public interface CmsSiteAccessCountDao {

	public List<Object[]> statisticVisitorCountByDate(Integer siteId,Date begin,Date end);
	
	public List<Object[]> statisticVisitorCountByYear(Integer siteId,Integer year);

	public CmsSiteAccessCount save(CmsSiteAccessCount count);

	public CmsSiteAccessCount updateByUpdater(Updater<CmsSiteAccessCount> updater);

}
