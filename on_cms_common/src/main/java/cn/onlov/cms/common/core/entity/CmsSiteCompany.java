package cn.onlov.cms.common.core.entity;

import cn.onlov.cms.common.core.entity.base.BaseCmsSiteCompany;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;


public class CmsSiteCompany extends BaseCmsSiteCompany {
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
		if (StringUtils.isNotBlank(getScale())) {
			json.put("scale", getScale());
		}else{
			json.put("scale", "");
		}
		if (StringUtils.isNotBlank(getNature())) {
			json.put("nature", getNature());
		}else{
			json.put("nature", "");
		}
		if (StringUtils.isNotBlank(getIndustry())) {
			json.put("industry", getIndustry());
		}else{
			json.put("industry", "");
		}
		if (StringUtils.isNotBlank(getContact())) {
			json.put("contact", getContact());
		}else{
			json.put("contact", "");
		}
		if (StringUtils.isNotBlank(getDescription())) {
			json.put("description", getDescription());
		}else{
			json.put("description", "");
		}
		if (StringUtils.isNotBlank(getAddress())) {
			json.put("address", getAddress());
		}else{
			json.put("address", "");
		}
		if (getLongitude()!=null) {
			json.put("longitude", getLongitude());
		}else{
			json.put("longitude", "");
		}
		if (getLatitude()!=null) {
			json.put("latitude", getLatitude());
		}else{
			json.put("latitude", "");
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsSiteCompany () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsSiteCompany (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsSiteCompany (
		Integer id,
		String name) {

		super (
			id,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}