package cn.onlov.on_cms_common.core.entity;

import cn.onlov.on_cms_common.core.entity.base.BaseCmsUserSite;
import org.json.JSONObject;

public class CmsUserSite extends BaseCmsUserSite {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (getCheckStep()!=null) {
			json.put("checkStep", getCheckStep());
		}else{
			json.put("checkStep", "");
		}
		if (getAllChannel()!=null) {
			json.put("allChannel", getAllChannel());
		}else{
			json.put("allChannel", "");
		}
		return json;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsUserSite () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsUserSite (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsUserSite (
		Integer id,
		CmsUser user,
		CmsSite site,
		Byte checkStep,
		Boolean allChannel) {

		super (
			id,
			user,
			site,
			checkStep,
			allChannel);
	}

	/* [CONSTRUCTOR MARKER END] */

}