package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.common.util.DateUtils;
import cn.onlov.on_cms_common.core.entity.CmsUser;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsJobApply;


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