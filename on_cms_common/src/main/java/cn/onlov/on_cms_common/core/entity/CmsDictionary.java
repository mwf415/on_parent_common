package cn.onlov.on_cms_common.core.entity;

import cn.onlov.on_cms_common.core.entity.base.BaseCmsDictionary;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class CmsDictionary extends BaseCmsDictionary {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson() 
			throws JSONException{
		JSONObject json=new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getValue())) {
			json.put("value", getValue());
		}else{
			json.put("value", "");
		}
		if (StringUtils.isNotBlank(getName())) {
			json.put("name", getName());
		}else{
			json.put("name", "");
		}
		if (StringUtils.isNotBlank(getType())) {
			json.put("type", getType());
		}else{
			json.put("type", "");
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsDictionary () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsDictionary (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsDictionary (
		Integer id,
		String name,
		String value,
		String type) {

		super (
			id,
			name,
			value,
			type);
	}

/*[CONSTRUCTOR MARKER END]*/


}