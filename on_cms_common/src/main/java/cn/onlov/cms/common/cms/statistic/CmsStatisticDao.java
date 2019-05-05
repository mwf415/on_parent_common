package cn.onlov.cms.common.cms.statistic;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CmsStatisticDao {
	public long memberStatistic(CmsStatistic.TimeRange timeRange);
	
	public List<Object[]> statisticMemberByTarget(Integer target,
                                                  Date timeBegin, Date timeEnd);

	public long contentStatistic(CmsStatistic.TimeRange timeRange,
                                 Map<String, Object> restrictions);

	public List<Object[]> statisticContentByTarget(Integer target,
                                                   Date timeBegin, Date timeEnd, Map<String, Object> restrictions);

	public List<Object[]> statisticCommentByTarget(
            Integer target, Integer siteId, Boolean isReplyed, Date timeBegin, Date timeEnd);


	public List<Object[]> statisticGuestbookByTarget(Integer target, Integer siteId,
                                                     Boolean isReplyed, Date timeBegin, Date timeEnd);

	public long commentStatistic(CmsStatistic.TimeRange timeRange,
                                 Map<String, Object> restrictions);

	public long guestbookStatistic(CmsStatistic.TimeRange timeRange,
                                   Map<String, Object> restrictions);
	
	
}
