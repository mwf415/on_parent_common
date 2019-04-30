package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.core.entity.CmsSite;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsFriendlink;

public class CmsFriendlink extends BaseCmsFriendlink {
	private static final long serialVersionUID = 1L;

	public void init() {
		if (getPriority() == null) {
			setPriority(10);
		}
		if (getViews() == null) {
			setViews(0);
		}
		if (getEnabled() == null) {
			setEnabled(true);
		}
		blankToNull();
	}

	public void blankToNull() {
		if (StringUtils.isBlank(getLogo())) {
			setLogo(null);
		}
	}
	
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
		if (StringUtils.isNotBlank(getDomain())) {
			json.put("domain", getDomain());
		}else{
			json.put("domain", "");
		}
		if(StringUtils.isNotBlank(getLogo())){
			json.put("logo", getLogo());
		}else{
			json.put("logo", "");
		}
		if (StringUtils.isNotBlank(getEmail())) {
			json.put("email", getEmail());
		}else{
			json.put("email", "");
		}
		if (StringUtils.isNotBlank(getDescription())) {
			json.put("description", getDescription());
		}else{
			json.put("description", "");
		}
		if (getViews()!=null) {
			json.put("views", getViews());
		}else{
			json.put("views", "");
		}
		if (getEnabled()!=null) {
			json.put("enabled", getEnabled());
		}else{
			json.put("enabled", "");
		}
		if (getCategory()!=null&&StringUtils.isNotBlank(getCategory().getName())) {
			json.put("categoryName", getCategory().getName());
		}else{
			json.put("categoryName", "");
		}
		if (getCategory()!=null&&getCategory().getId()!=null) {
			json.put("categoryId", getCategory().getId());
		}else{
			json.put("categoryId", "");
		}
		return json;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsFriendlink() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsFriendlink(Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsFriendlink(Integer id,
                         CmsFriendlinkCtg category,
                         CmsSite site, String name,
                         String domain, Integer views,
                         Integer priority, Boolean enabled) {

		super(id, category, site, name, domain, views, priority, enabled);
	}

	/* [CONSTRUCTOR MARKER END] */

}