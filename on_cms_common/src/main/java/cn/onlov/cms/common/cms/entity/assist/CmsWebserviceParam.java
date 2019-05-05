package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsWebserviceParam;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;


public class CmsWebserviceParam extends BaseCmsWebserviceParam {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (StringUtils.isNotBlank(getParamName())) {
			json.put("paramName", getParamName());
		}else{
			json.put("paramName", "");
		}
		if (StringUtils.isNotBlank(getDefaultValue())) {
			json.put("defaultValue", getDefaultValue());
		}else{
			json.put("defaultValue", "");
		}
		return json;
	}
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsWebserviceParam () {
		super();
	}

	/**
	 * Constructor for required fields
	 */
	public CmsWebserviceParam (
		String paramName) {

		super (
			paramName);
	}

/*[CONSTRUCTOR MARKER END]*/


}