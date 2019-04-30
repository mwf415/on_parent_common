package cn.onlov.on_cms_common.cms.entity.assist;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsOrigin;



public class CmsOrigin extends BaseCmsOrigin {
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
		if (getRefCount()!=null) {
			json.put("refCount", getRefCount());
		}else{
			json.put("refCount", "");
		}
		return json;
	}
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsOrigin () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsOrigin (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsOrigin (
		Integer id,
		String name,
		Integer refCount) {

		super (
			id,
			name,
			refCount);
	}

/*[CONSTRUCTOR MARKER END]*/


}