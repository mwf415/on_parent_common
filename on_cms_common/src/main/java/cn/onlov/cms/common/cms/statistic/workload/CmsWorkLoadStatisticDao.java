package cn.onlov.cms.common.cms.statistic.workload;

import cn.onlov.cms.common.cms.statistic.workload.CmsWorkLoadStatistic.CmsWorkLoadStatisticDateKind;

import java.util.Date;
import java.util.List;

public interface CmsWorkLoadStatisticDao {
	
	public Long  statistic(Integer channelId,
                           Integer reviewerId, Integer authorId,
                           Date beginDate, Date endDate,
                           CmsWorkLoadStatisticDateKind dateKind);

	public List<Object[]> statisticByTarget(Integer target,
                                            Integer channelId, Integer reviewerId,
                                            Integer authorId, Date beginDate, Date endDate);
}
