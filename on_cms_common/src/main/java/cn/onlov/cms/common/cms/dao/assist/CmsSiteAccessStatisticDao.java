package cn.onlov.cms.common.cms.dao.assist;

import java.util.Date;
import java.util.List;

import cn.onlov.cms.common.cms.entity.assist.CmsSiteAccessStatistic;

/**
 * @author Tom
 */
public interface CmsSiteAccessStatisticDao {
	public CmsSiteAccessStatistic save(CmsSiteAccessStatistic statistic);

	public List<Object[]> statistic(Date begin, Date end,Integer siteId, String statisticType,String statisticValue);
	
	public List<Object[]> statisticTotal(Date begin, Date end,Integer siteId, String statisticType,String statisticValue,Integer orderBy);
	
	public List<Object[]> statisticByTarget(Date begin, Date end,Integer siteId,Integer target, String statisticType,String statisticValue);
	
	public List<String> findStatisticColumnValues(Date begin, Date end,Integer siteId, String statisticType);
	
	public List<Object[]> statisticByYear(Integer year,Integer siteId, String statisticType,String statisticValue,boolean groupByMonth,Integer orderBy);
	
	public List<Object[]> statisticByYearByTarget(Integer year,Integer siteId, Integer target,String statisticType,String statisticValue);
	
}
