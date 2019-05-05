package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsSiteAccessStatistic;
import cn.onlov.cms.common.core.entity.CmsSite;


public class CmsSiteAccessStatistic extends BaseCmsSiteAccessStatistic {
	public static final String STATISTIC_ALL = "all";
	public static final String STATISTIC_SOURCE = "source";
	public static final String STATISTIC_ENGINE = "engine";
	public static final String STATISTIC_LINK = "link";
	public static final String STATISTIC_KEYWORD = "keyword";
	public static final String STATISTIC_AREA = "area";
	public static final String STATISTIC_BROWER = "brower";
	public static final String STATISTIC_SYSTEM = "system";
	public static final long serialVersionUID = 1L;
	public static final int STATISTIC_TARGET_PV = 0;
	public static final int STATISTIC_TARGET_IP = 1;
	public static final int STATISTIC_TARGET_VISITORS= 2;
	public static final int STATISTIC_TARGET_VISITSECOND = 3;
	public static final int STATISTIC_TARGET_ALL = 4;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsSiteAccessStatistic () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsSiteAccessStatistic (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsSiteAccessStatistic (
		Integer id,
		CmsSite site,
		java.util.Date statisticDate,
		Long pv,
		Long ip,
		Long visitors,
		Long pagesAver,
		Long visitSecondAver,
		String statisitcType) {

		super (
			id,
			site,
			statisticDate,
			pv,
			ip,
			visitors,
			pagesAver,
			visitSecondAver,
			statisitcType);
	}

/*[CONSTRUCTOR MARKER END]*/


}