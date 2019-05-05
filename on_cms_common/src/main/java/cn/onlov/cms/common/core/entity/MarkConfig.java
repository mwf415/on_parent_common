package cn.onlov.cms.common.core.entity;

import cn.onlov.cms.common.core.entity.base.BaseMarkConfig;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;


public class MarkConfig extends BaseMarkConfig {
	private static final long serialVersionUID = 1L;
	
	public JSONObject convertToJson(){

		JSONObject json = new JSONObject();
		if (getOn()!=null) {
			json.put("on", getOn());
		}else{
			json.put("on", "");
		}
		if (getMinWidth()!=null) {
			json.put("minWidth", getMinWidth());
		}else{
			json.put("minWidth", "");
		}
		if (getMinHeight()!=null) {
			json.put("minHeight", getMinHeight());
		}else{
			json.put("minHeight", "");
		}
		if (StringUtils.isNotBlank(getImagePath())) {
			json.put("imagePath", getImagePath());
		}else{
			json.put("imagePath", "");
		}
		if (StringUtils.isNotBlank(getContent())) {
			json.put("content", getContent());
		}else{
			json.put("content", "");
		}
		if (getSize()!=null) {
			json.put("size", getSize());
		}else{
			json.put("size", "");
		}
		if (StringUtils.isNotBlank(getColor())) {
			json.put("color", getColor());
		}else{
			json.put("color", "");
		}
		if (getAlpha()!=null) {
			json.put("alpha", getAlpha());
		}else{
			json.put("alpha", "");
		}
		if (getPos()!=null) {
			json.put("pos", getPos());
		}else{
			json.put("pos", "");
		}
		if (getOffsetX()!=null) {
			json.put("offsetX", getOffsetX());
		}else{
			json.put("offsetX", "");
		}
		if (getOffsetY()!=null) {
			json.put("offsetY", getOffsetY());
		}else{
			json.put("offsetY", "");
		}
		return json;
	
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MarkConfig () {
		super();
	}

	/**
	 * Constructor for required fields
	 */
	public MarkConfig (
		Boolean on,
		Integer minWidth,
		Integer minHeight,
		String content,
		Integer size,
		String color,
		Integer alpha,
		Integer pos,
		Integer offsetX,
		Integer offsetY) {

		super (
			on,
			minWidth,
			minHeight,
			content,
			size,
			color,
			alpha,
			pos,
			offsetX,
			offsetY);
	}

/*[CONSTRUCTOR MARKER END]*/


}