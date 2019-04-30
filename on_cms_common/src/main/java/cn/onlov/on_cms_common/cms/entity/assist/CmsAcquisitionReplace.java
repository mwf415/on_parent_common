package cn.onlov.on_cms_common.cms.entity.assist;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsAcquisitionReplace;


public class CmsAcquisitionReplace extends BaseCmsAcquisitionReplace {
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getKeyword())) {
			json.put("keyword", getKeyword());
		}else{
			json.put("keyword", "");
		}
		if (StringUtils.isNotBlank(getReplaceWord())) {
			json.put("replaceWord", getReplaceWord());
		}else{
			json.put("replaceWord", "");
		}
		return json;
	}
	
	public void init() {
		
	}
	
	public CmsAcquisitionReplace() {
		// TODO Auto-generated constructor stub
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsAcquisitionReplace (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsAcquisitionReplace (
		Integer id,
		CmsAcquisition acquisition,
		String keyword,
		String replaceWord) {

		super (
			id,
			acquisition,
			keyword,
			replaceWord);
	}
}
