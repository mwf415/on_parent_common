package cn.onlov.cms.common.cms.entity.main;

import cn.onlov.cms.common.cms.entity.main.base.BaseApiRecord;
import cn.onlov.cms.common.common.util.DateUtils;
import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;



public class ApiRecord extends BaseApiRecord {
	private static final long serialVersionUID = 1L;

	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (getCallTime()!=null) {
			json.put("callTime", DateUtils.parseDateToDateStr(getCallTime()));
		}else{
			json.put("callTime", "");
		}
		if (StringUtils.isNotBlank(getCallIp())) {
			json.put("callIp", getCallIp());
		}else{
			json.put("callIp", "");
		}
		if (getApiAccount()!=null && StringUtils.isNotBlank(getApiAccount().getAppId())) {
			json.put("apiAppId", getApiAccount().getAppId());
		}else{
			json.put("apiAppId", "");
		}
		if (getApiInfo()!=null && StringUtils.isNotBlank(getApiInfo().getName())) {
			json.put("apiInfoName", getApiInfo().getName());
		}else{
			json.put("apiInfoName", "");
		}
		return json;
	}
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public ApiRecord () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ApiRecord (Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ApiRecord (
		Long id,
		ApiAccount apiAccount,
		ApiInfo apiInfo,
		java.util.Date callTime,
		Long callTimeStamp) {

		super (
			id,
			apiAccount,
			apiInfo,
			callTime,
			callTimeStamp);
	}

/*[CONSTRUCTOR MARKER END]*/


}