package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsSiteFlow;
import cn.onlov.on_cms_common.core.entity.CmsSite;


public class CmsSiteFlow extends BaseCmsSiteFlow {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsSiteFlow () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsSiteFlow (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsSiteFlow (
		Integer id,
		CmsSite site,
		String accessIp,
		String accessDate,
		String accessPage,
		String sessionId) {

		super (
			id,
			site,
			accessIp,
			accessDate,
			accessPage,
			sessionId);
	}

/*[CONSTRUCTOR MARKER END]*/


}