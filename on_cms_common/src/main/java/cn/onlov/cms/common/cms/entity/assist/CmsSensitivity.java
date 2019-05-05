package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsSensitivity;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;


public class CmsSensitivity extends BaseCmsSensitivity {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getSearch())) {
			json.put("search", getSearch());
		}else{
			json.put("search", "");
		}
		if (StringUtils.isNotBlank(getReplacement())) {
			json.put("replacement", getReplacement());
		}else{
			json.put("replacement", "");
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsSensitivity () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsSensitivity (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsSensitivity (
		Integer id,
		String search,
		String replacement) {

		super (
			id,
			search,
			replacement);
	}

/*[CONSTRUCTOR MARKER END]*/


}