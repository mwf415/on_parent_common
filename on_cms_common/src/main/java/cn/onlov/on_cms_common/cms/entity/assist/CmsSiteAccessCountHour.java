package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsSiteAccessCountHour;
import cn.onlov.on_cms_common.core.entity.CmsSite;


public class CmsSiteAccessCountHour extends BaseCmsSiteAccessCountHour {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsSiteAccessCountHour () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsSiteAccessCountHour (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsSiteAccessCountHour (
		Integer id,
		CmsSite site,
		Long hourPv,
		Long hourIp,
		Long hourUv,
		java.util.Date accessDate,
		Integer accessHour) {

		super (
			id,
			site,
			hourPv,
			hourIp,
			hourUv,
			accessDate,
			accessHour);
	}

/*[CONSTRUCTOR MARKER END]*/


}