package cn.onlov.cms.common.plug.store.entity;

import cn.onlov.cms.common.plug.store.entity.base.BasePlugStoreConfig;


public class PlugStoreConfig extends BasePlugStoreConfig {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public PlugStoreConfig () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public PlugStoreConfig (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public PlugStoreConfig (
		Integer id,
		String serverUrl,
		String passwod) {

		super (
			id,
			serverUrl,
			passwod);
	}

/*[CONSTRUCTOR MARKER END]*/


}