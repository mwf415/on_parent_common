package cn.onlov.on_cms_common.cms.entity.main;

import cn.onlov.on_cms_common.cms.entity.main.base.BaseApiUserLogin;



public class ApiUserLogin extends BaseApiUserLogin {
	private static final long serialVersionUID = 1L;
	public static Short USER_STATUS_LOGIN=1;
	public static Short USER_STATUS_LOGOUT=2;
	public static Short USER_STATUS_LOGOVERTIME=3;
	public static Short USER_STATUS_FORGE=4;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ApiUserLogin () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ApiUserLogin (Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ApiUserLogin (
		Long id,
		String sesssionKey,
		String username,
		java.util.Date loginTime,
		Integer loginCount) {

		super (
			id,
			sesssionKey,
			username,
			loginTime,
			loginCount);
	}

/*[CONSTRUCTOR MARKER END]*/


}