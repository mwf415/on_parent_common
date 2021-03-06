package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsScoreItem;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;


public class CmsScoreItem extends BaseCmsScoreItem {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (getScore()!=null) {
			json.put("score", getScore());
		}else{
			json.put("score", "");
		}
		if (StringUtils.isNotBlank(getName())) {
			json.put("name", getName());
		}else{
			json.put("name", "");
		}
		if (StringUtils.isNotBlank(getImagePath())) {
			json.put("imagePath", getImagePath());
		}else{
			json.put("imagePath", "");
		}
		if (getPriority()!=null) {
			json.put("priority", getPriority());
		}else{
			json.put("priority", "");
		}
		if (getGroup()!=null&&StringUtils.isNotBlank(getGroup().getName())) {
			json.put("groupName", getGroup().getName());
		}else{
			json.put("groupName", "");
		}
		if (getGroup()!=null&&getGroup().getId()!=null) {
			json.put("groupId", getGroup().getId());
		}else{
			json.put("groupId", "");
		}
		return json;
	}
	
	public void init(){
		if (getPriority()==null) {
			setPriority(10);
		}
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsScoreItem () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsScoreItem (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsScoreItem (
		Integer id,
		CmsScoreGroup group,
		String name,
		Integer score,
		Integer priority) {

		super (
			id,
			group,
			name,
			score,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}