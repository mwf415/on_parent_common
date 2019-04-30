package cn.onlov.on_cms_common.cms.statistic;

import cn.onlov.on_cms_common.cms.statistic.CmsStatistic.CmsStatisticModel;
import cn.onlov.on_cms_common.cms.statistic.CmsStatistic.TimeRange;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CmsStatisticSvc {
	public List<CmsStatistic> statisticByModel(int type,
                                               CmsStatisticModel statisticModel, Integer year, Integer month,
                                               Integer day, Date begin, Date end, Map<String, Object> restrictions);

	public long statistic(int type, TimeRange timeRange,
                          Map<String, Object> restrictions);

	public List<Object[]> statisticMemberByTarget(Integer target,
                                                  Date timeBegin, Date timeEnd);

	public List<Object[]> statisticContentByTarget(Integer target,
                                                   Date timeBegin, Date timeEnd, Map<String, Object> restrictions);

	public List<Object[]> statisticCommentByTarget(Integer target, Integer siteId,
                                                   Boolean isReplyed, Date timeBegin, Date timeEnd);

	public List<Object[]> statisticGuestbookByTarget(Integer target, Integer siteId,
                                                     Boolean isReplyed, Date timeBegin, Date timeEnd);
	
}
