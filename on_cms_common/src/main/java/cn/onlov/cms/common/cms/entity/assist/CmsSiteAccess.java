package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsSiteAccess;
import cn.onlov.cms.common.core.entity.CmsSite;


public class CmsSiteAccess extends BaseCmsSiteAccess {
	private static final long serialVersionUID = 1L;
	
	public static final String ENGINE_BAIDU=".baidu.";
	public static final String ENGINE_GOOGLE=".google.";
	public static final String ENGINE_YAHOO=".yahoo.";
	public static final String ENGINE_BING=".bing.";
	public static final String ENGINE_SOGOU=".sogou.";
	public static final String ENGINE_SOSO=".soso.";
	public static final String ENGINE_SO=".so.";

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsSiteAccess () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsSiteAccess (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsSiteAccess (
		Integer id,
		CmsSite site,
		String sessionId,
		java.util.Date accessTime,
		java.util.Date accessDate) {

		super (
			id,
			site,
			sessionId,
			accessTime,
			accessDate);
	}

/*[CONSTRUCTOR MARKER END]*/


}