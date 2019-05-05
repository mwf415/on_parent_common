package cn.onlov.cms.common.cms.entity.assist;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsReceiverMessage;
import cn.onlov.cms.common.common.util.DateUtils;
import cn.onlov.cms.common.common.util.StrUtils;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.entity.CmsUser;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class CmsReceiverMessage extends BaseCmsReceiverMessage {
	
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
		json.put("msgStatus", isMsgStatus());
		if (getMsgBox()!=null) {
			json.put("msgBox", getMsgBox());
		}else{
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
	
	private static final long serialVersionUID = 1L;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsReceiverMessage() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsReceiverMessage(Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsReceiverMessage(Integer id,
                              CmsUser msgReceiverUser,
                              CmsUser msgSendUser,
                              CmsSite site, String msgTitle,
                              String msgContent, java.util.Date sendTime,
                              boolean msgStatus, Integer msgBox) {

		super(id, msgReceiverUser, msgSendUser, site, msgTitle, msgContent,
				sendTime, msgStatus, msgBox);
	}

	public CmsReceiverMessage(CmsMessage message) {
		super(message.getId(), message.getMsgReceiverUser(), message
				.getMsgSendUser(), message.getSite(), message.getMsgTitle(),
				message.getMsgContent(), message.getSendTime(), message
						.getMsgStatus(), message.getMsgBox());
	}
	public String getTitleHtml() {
		return StrUtils.txt2htm(getMsgTitle());
	}
	public String getContentHtml() {
		return StrUtils.txt2htm(getMsgContent());
	}

	/* [CONSTRUCTOR MARKER END] */

}