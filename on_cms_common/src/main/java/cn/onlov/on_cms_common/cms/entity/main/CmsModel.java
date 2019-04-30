package cn.onlov.on_cms_common.cms.entity.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.onlov.on_cms_common.cms.Constants;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import cn.onlov.on_cms_common.cms.entity.main.base.BaseCmsModel;

public class CmsModel extends BaseCmsModel {
	private static final long serialVersionUID = 1L;
	private static final Integer TITLE_IMG_WIDTH = 139;
	private static final Integer TITLE_IMG_HEIGHT = 139;
	private static final Integer CONTENT_IMG_WIDTH = 310;
	private static final Integer CONTENT_IMG_HEIGHT = 310;
	
	public JSONObject convertToJson() {
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (StringUtils.isNotBlank(getName())) {
			json.put("name", getName());
		}else{
			json.put("name", "");
		}
		if (StringUtils.isNotBlank(getPath())) {
			json.put("path", getPath());
		}else{
			json.put("path", "");
		}
		if (StringUtils.isNotBlank(getTplChannelPrefix())) {
			json.put("tplChannelPrefix", getTplChannelPrefix());
		}else{
			json.put("tplChannelPrefix", "");
		}
		if (StringUtils.isNotBlank(getTplContentPrefix())) {
			json.put("tplContentPrefix", getTplContentPrefix());
		}else{
			json.put("tplContentPrefix", "");
		}
		if (getTitleImgWidth()!=null) {
			json.put("titleImgWidth", getTitleImgWidth());
		}else{
			json.put("titleImgWidth", "");
		}
		if (getTitleImgHeight()!=null) {
			json.put("titleImgHeight", getTitleImgHeight());
		}else{
			json.put("titleImgHeight", "");
		}
		if (getContentImgWidth()!=null) {
			json.put("contentImgWidth", getContentImgWidth());
		}else{
			json.put("contentImgWidth", "");
		}
		if (getContentImgHeight()!=null) {
			json.put("contentImgHeight", getContentImgHeight());
		}else{
			json.put("contentImgHeight", "");
		}
		if (getPriority()!=null) {
			json.put("priority", getPriority());
		}else{
			json.put("priority", "");
		}
		if (getHasContent()!=null) {
			json.put("hasContent", getHasContent());
		}else{
			json.put("hasContent", "");
		}
		if (getDisabled()!=null) {
			json.put("disabled", getDisabled());
		}else{
			json.put("disabled", "");
		}
		if (getDef()!=null) {
			json.put("def", getDef());
		}else{
			json.put("def", "");
		}
		if (getGlobal()!=null) {
			json.put("global", getGlobal());
		}else{
			json.put("global", "");
		}
		return json;
	}

	public String getTplChannel(String solution, boolean def) {
		StringBuilder t = new StringBuilder();
		t.append(solution).append("/");
		if (getHasContent()) {
			t.append(Constants.TPLDIR_CHANNEL);
		} else {
			t.append(Constants.TPLDIR_ALONE);
		}
		t.append("/");
		String prefix = getTplChannelPrefix();
		if (def) {
			if (!StringUtils.isBlank(prefix)) {
				t.append(prefix);
			} else {
				t.append(cn.onlov.on_cms_common.common.web.Constants.DEFAULT);
			}
			t.append(Constants.TPL_SUFFIX);
		} else {
			if (!StringUtils.isBlank(prefix)) {
				t.append(prefix);
			}
		}
		return t.toString();
	}

	public String getTplContent(String solution, boolean def) {
		StringBuilder t = new StringBuilder();
		t.append(solution).append("/");
		t.append(Constants.TPLDIR_CONTENT);
		t.append("/");
		String prefix = getTplContentPrefix();
		if (def) {
			if (!StringUtils.isBlank(prefix)) {
				t.append(prefix);
			} else {
				t.append(cn.onlov.on_cms_common.common.web.Constants.DEFAULT);
			}
			t.append(Constants.TPL_SUFFIX);
		} else {
			if (!StringUtils.isBlank(prefix)) {
				t.append(prefix);
			}
		}
		return t.toString();

	}
	
	
	public List<String> getModelItems(){
		Set<CmsModelItem>items=getItems();
		List<String>fileList=new ArrayList<String>();
		Iterator<CmsModelItem>it=items.iterator();
		while(it.hasNext()){
			fileList.add(it.next().getField());
		}
		return fileList;
	}
	
	public CmsModelItem findModelItem(String field,boolean isChannel){
		CmsModelItem item=null;
		Set<CmsModelItem>items=getItems();
		for(CmsModelItem modelItem:items){
			if(modelItem.getChannel().equals(isChannel)&&modelItem.getField().equals(field)){
				item=modelItem;
				break;
			}
		}
		return item;
	}

	public void init() {
		if (getDisabled() == null) {
			setDisabled(false);
		}
		if (getDef() == null) {
			setDef(false);
		}
		if (getContentImgWidth()==null) {
			setContentImgHeight(CONTENT_IMG_HEIGHT);
		}
		if (getContentImgWidth()==null) {
			setContentImgWidth(CONTENT_IMG_WIDTH);
		}
		if (getTitleImgWidth()==null) {
			setTitleImgWidth(TITLE_IMG_WIDTH);
		}
		if (getTitleImgHeight()==null) {
			setTitleImgHeight(TITLE_IMG_HEIGHT);
		}
		if (getPriority()==null) {
			setPriority(10);
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsModel() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsModel(Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsModel(Integer id, String name,
                    String path, Integer titleImgWidth,
                    Integer titleImgHeight,
                    Integer contentImgWidth,
                    Integer contentImgHeight, Integer priority,
                    Boolean hasContent, Boolean disabled,
                    Boolean def) {

		super(id, name, path, titleImgWidth, titleImgHeight, contentImgWidth,
				contentImgHeight, priority, hasContent, disabled, def);
	}

	

	/* [CONSTRUCTOR MARKER END] */

}