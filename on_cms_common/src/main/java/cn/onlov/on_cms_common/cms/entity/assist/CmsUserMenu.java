package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsUserMenu;
import cn.onlov.on_cms_common.core.entity.CmsUser;


public class CmsUserMenu extends BaseCmsUserMenu {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsUserMenu () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsUserMenu (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsUserMenu (
		Integer id,
		CmsUser user,
		String name,
		String url,
		Integer priority) {

		super (
			id,
			user,
			name,
			url,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}