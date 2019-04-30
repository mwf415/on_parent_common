package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.core.entity.CmsUser;
import org.apache.commons.lang.StringUtils;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsDirectiveTpl;

import net.sf.json.JSONObject;



public class CmsDirectiveTpl extends BaseCmsDirectiveTpl {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getName())) {
			json.put("name", getName());
		}else{
			json.put("name", "");
		}
		if (StringUtils.isNotBlank(getDescription())) {
			json.put("description", getDescription());
		}else{
			json.put("description", "");
		}
		if (StringUtils.isNotBlank(getCode())) {
			json.put("code", getCode());
		}else{
			json.put("code", "");
		}
		if (getUser()!=null&&StringUtils.isNotBlank(getUser().getUsername())) {
			json.put("username", getUser().getUsername());
		}else{
			json.put("username", "");
		}
		
		return json;
	}
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsDirectiveTpl () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsDirectiveTpl (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsDirectiveTpl (
		Integer id,
		CmsUser user,
		String name) {

		super (
			id,
			user,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}