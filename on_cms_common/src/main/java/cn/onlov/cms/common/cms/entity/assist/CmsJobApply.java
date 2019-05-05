package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsJobApply;
import cn.onlov.cms.common.common.util.DateUtils;
import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.cms.entity.main.Content;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;


public class CmsJobApply extends BaseCmsJobApply {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){
		JSONObject json=new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (getApplyTime()!=null) {
			json.put("applyTime", DateUtils.parseDateToTimeStr(getApplyTime()));
		}else{
			json.put("applyTime","");
		}
		if (getContent()!=null&&getContent().getId()!=null) {
			json.put("contentId",getContent().getId());
		}else{
			json.put("contentId", "");
		}
		if (getContent()!=null&&StringUtils.isNotBlank(getContent().getTitle())) {
			json.put("contentTitle",getContent().getTitle());
		}else{
			json.put("contentTitle","");
		}
		if (getContent()!=null&&StringUtils.isNotBlank(getContent().getUrl())) {
			json.put("contentURL", getContent().getUrl());
		}else{
			json.put("contentURL", "");
		}
		if (getUser()!=null && getUser().getId()!=null) {
			json.put("userId", getUser().getId());
		}else{
			json.put("userId", "");
		}
		if (getUser()!=null && StringUtils.isNotBlank(getUser().getUsername())) {
			json.put("username", getUser().getUsername());
		}else{
			json.put("username", "");
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsJobApply () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsJobApply (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsJobApply (
		Integer id,
		Content content,
		CmsUser user,
		java.util.Date applyTime) {

		super (
			id,
			content,
			user,
			applyTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}