package cn.onlov.cms.common.cms.manager.assist;

import java.util.Date;
import java.util.List;

import cn.onlov.cms.common.cms.entity.assist.CmsSiteAccessCount;

/**
 * @author Tom
 */
public interface CmsSiteAccessCountMng {
	public List<Object[]> statisticVisitorCountByDate(Integer siteId,Date begin, Date end);

	public List<Object[]> statisticVisitorCountByYear(Integer siteId,Integer year);

	public CmsSiteAccessCount save(CmsSiteAccessCount count);

	public void statisticCount(Date date, Integer siteId);
}
