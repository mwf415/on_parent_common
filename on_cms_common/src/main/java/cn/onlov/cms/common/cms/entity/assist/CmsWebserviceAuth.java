package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsWebserviceAuth;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;


public class CmsWebserviceAuth extends BaseCmsWebserviceAuth {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getUsername())) {
			json.put("username", getUsername());
		}else{
			json.put("username", "");
		}
		if (StringUtils.isNotBlank(getPassword())) {
			json.put("password", getPassword());
		}else{
			json.put("password", "");
		}
		if (StringUtils.isNotBlank(getSystem())) {
			json.put("system", getSystem());
		}else{
			json.put("system", "");
		}
		json.put("enable", getEnable());
		return json;
	}

	public boolean getEnable() {
		return super.isEnable();
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsWebserviceAuth () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsWebserviceAuth (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsWebserviceAuth (
		Integer id,
		String username,
		String password,
		String system,
		boolean enable) {

		super (
			id,
			username,
			password,
			system,
			enable);
	}

/*[CONSTRUCTOR MARKER END]*/


}