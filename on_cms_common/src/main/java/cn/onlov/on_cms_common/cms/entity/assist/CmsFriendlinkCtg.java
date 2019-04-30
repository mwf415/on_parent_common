package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.core.entity.CmsSite;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsFriendlinkCtg;



public class CmsFriendlinkCtg extends BaseCmsFriendlinkCtg {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson() 
			throws JSONException{
		JSONObject json=new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (getPriority()!=null) {
			json.put("priority", getPriority());
		}else{
			json.put("priority", "");
		}
		if (StringUtils.isNotBlank(getName())) {
			json.put("name", getName());
		}else{
			json.put("name", "");
		}
		return json;
	}
	
	public void init(){
		if (getPriority()==null) {
			setPriority(10);
		}
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsFriendlinkCtg () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsFriendlinkCtg (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsFriendlinkCtg (
		Integer id,
		CmsSite site,
		String name,
		Integer priority) {

		super (
			id,
			site,
			name,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}