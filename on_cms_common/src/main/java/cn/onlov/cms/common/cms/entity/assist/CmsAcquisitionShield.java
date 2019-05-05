package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsAcquisitionShield;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class CmsAcquisitionShield extends BaseCmsAcquisitionShield {
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getShieldStart())) {
			json.put("shieldStart", getShieldStart());
		}else{
			json.put("shieldStart", "");
		}
		if (StringUtils.isNotBlank(getShieldEnd())) {
			json.put("shieldEnd", getShieldEnd());
		}else{
			json.put("shieldEnd", "");
		}
		return json;
	}
	
	public CmsAcquisitionShield() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsAcquisitionShield (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsAcquisitionShield (
		Integer id,
		CmsAcquisition acquisition,
		String shieldStart,
		String shieldEnd) {

		super (
			id,
			acquisition,
			shieldStart,
			shieldEnd);
	}
}
