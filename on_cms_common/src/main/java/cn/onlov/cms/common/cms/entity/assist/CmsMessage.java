package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsMessage;
import cn.onlov.cms.common.common.util.DateUtils;
import cn.onlov.cms.common.common.util.StrUtils;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.entity.CmsUser;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class CmsMessage extends BaseCmsMessage {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson() 
			throws JSONException{
		JSONObject json=new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getMsgTitle())) {
			json.put("msgTitle", getMsgTitle());
		}else{
			json.put("msgTitle", "");
		}
		if (StringUtils.isNotBlank(getMsgContent())) {
			json.put("msgContent", getMsgContent());
		}else{
			json.put("msgContent", "");
		}
		if (getSendTime()!=null) {
			json.put("sendTime", DateUtils.parseDateToTimeStr(getSendTime()));
		}else{
			json.put("sendTime", "");
		}
		if (getMsgStatus()!=null) {
			json.put("msgStatus", getMsgStatus());
		}else{
			json.put("msgStatus", "");
		}
		if (getMsgBox()!=null) {
			json.put("msgBox", getMsgBox());
		}else {
			json.put("msgBox", "");
		}
		if(getMsgReceiverUser()!=null&&StringUtils.isNotBlank(getMsgReceiverUser().getUsername())){
			json.put("msgReceiverUserName", getMsgReceiverUser().getUsername());
		}else{
			json.put("msgReceiverUserName", "");
		}
		if (getMsgReceiverUser()!=null&&getMsgReceiverUser().getId()!=null) {
			json.put("msgReceiverId", getMsgReceiverUser().getId());
		}else{
			json.put("msgReceiverId", "");
		}
		if(getMsgSendUser()!=null&&StringUtils.isNotBlank(getMsgSendUser().getUsername())){
			json.put("msgSendUserUserName", getMsgSendUser().getUsername());
		}else{
			json.put("msgSendUserUserName", "");
		}
		if(getMsgSendUser()!=null&&getMsgSendUser().getId()!=null){
			json.put("msgSendUserId", getMsgSendUser().getId());
		}else{
			json.put("msgSendUserId", "");
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsMessage () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsMessage (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsMessage (
		Integer id,
		CmsUser msgReceiverUser,
		CmsUser msgSendUser,
		CmsSite site,
		String msgTitle,
		Boolean msgStatus,
		Integer msgBox) {

		super (
			id,
			msgReceiverUser,
			msgSendUser,
			site,
			msgTitle,
			msgStatus,
			msgBox);
	}
	public String getTitleHtml() {
		return StrUtils.txt2htm(getMsgTitle());
	}
	public String getContentHtml() {
		return StrUtils.txt2htm(getMsgContent());
	}


/*[CONSTRUCTOR MARKER END]*/


}