package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsKeyword;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class CmsKeyword extends BaseCmsKeyword {
	private static final long serialVersionUID = 1L;

	public void init() {
		if (getDisabled() == null) {
			setDisabled(false);
		}
	}
	
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
		if (StringUtils.isNotBlank(getUrl())) {
			json.put("url", getUrl());
		}else{
			json.put("url", "");
		}
		if (getDisabled()!=null) {
			json.put("disabled", getDisabled());
		}else{
			json.put("disabled", "");
		}
		return json;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsKeyword () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsKeyword (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsKeyword (
		Integer id,
		String name,
		String url,
		Boolean disabled) {

		super (
			id,
			name,
			url,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */

}