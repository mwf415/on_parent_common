package cn.onlov.cms.common.core.entity;

import cn.onlov.cms.common.common.util.DateUtils;
import cn.onlov.cms.common.core.entity.base.BaseCmsUserAccount;
import org.apache.commons.lang.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;


public class CmsUserAccount extends BaseCmsUserAccount {
	private static final long serialVersionUID = 1L;
	
	public static final byte DRAW_WEIXIN=0;
	
	public static final byte DRAW_ALIPY=1;
	
	public JSONObject convertToJson() 
			throws JSONException{
		JSONObject json=new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (getContentTotalAmount()!=null) {
			json.put("contentTotalAmount", getContentTotalAmount());
		}else{
			json.put("contentTotalAmount", "");
		}
		if (getContentNoPayAmount()!=null) {
			json.put("contentNoPayAmount", getContentNoPayAmount());
		}else{
			json.put("contentNoPayAmount", "");
		}
		if (getContentYearAmount()!=null) {
			json.put("contentYearAmount", getContentYearAmount());
		}else{
			json.put("contentYearAmount", "");
		}
		if (getContentMonthAmount()!=null) {
			json.put("contentMonthAmount", getContentMonthAmount());
		}else{
			json.put("contentMonthAmount", "");
		}
		if (getContentDayAmount()!=null) {
			json.put("contentDayAmount", getContentDayAmount());
		}else{
			json.put("contentDayAmount", "");
		}
		if (getDrawCount()!=null) {
			json.put("drawCount", getDrawCount());
		}else{
			json.put("drawCount", "");
		}
		if (getContentBuyCount()!=null) {
			json.put("contentBuyCount", getContentBuyCount());
		}else{
			json.put("contentBuyCount", "");
		}
		if (getDrawAccount()!=null) {
			json.put("drawAccount", getDrawAccount());
		}else{
			json.put("drawAccount", "");
		}
		if (getUser()!=null&&StringUtils.isNotBlank(getUser().getUsername())) {
			json.put("userName", getUser().getUsername());
		}else{
			json.put("userName", "");
		}
		if (getUser()!=null&&StringUtils.isNotBlank(getUser().getRealname())) {
			json.put("realname", getUser().getRealname());
		}else{
			json.put("realname", "");
		}
		if(getLastDrawTime()!=null){
			json.put("lastDrawTime", DateUtils.parseDateToTimeStr(getLastDrawTime()));
		}else{
			json.put("lastDrawTime", "");
		}
		if(getLastBuyTime()!=null){
			json.put("lastBuyTime", DateUtils.parseDateToTimeStr(getLastBuyTime()));
		}else{
			json.put("lastBuyTime", "");
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsUserAccount () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsUserAccount (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsUserAccount (
		Integer id,
		Double contentYearAmount,
		Double contentMonthAmount,
		Double contentDayAmount,
		java.util.Date lastPaidTime) {

		super (
			id,
			contentYearAmount,
			contentMonthAmount,
			contentDayAmount,
			lastPaidTime);
	}

/*[CONSTRUCTOR MARKER END]*/


}