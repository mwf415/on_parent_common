package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsSiteAccessCount;
import cn.onlov.on_cms_common.core.entity.CmsSite;


public class CmsSiteAccessCount extends BaseCmsSiteAccessCount {
	private static final long serialVersionUID = 1L;
	

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsSiteAccessCount () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsSiteAccessCount (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsSiteAccessCount (
		Integer id,
		CmsSite site,
		Integer pageCount,
		Integer visitors,
		java.util.Date statisticDate) {

		super (
			id,
			site,
			pageCount,
			visitors,
			statisticDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}