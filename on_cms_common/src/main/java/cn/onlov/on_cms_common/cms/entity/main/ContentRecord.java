package cn.onlov.on_cms_common.cms.entity.main;

import cn.onlov.on_cms_common.common.util.DateUtils;
import cn.onlov.on_cms_common.core.entity.CmsUser;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import cn.onlov.on_cms_common.cms.entity.main.base.BaseContentRecord;


public class ContentRecord extends BaseContentRecord {
	private static final long serialVersionUID = 1L;
	public enum ContentOperateType {
		/**
		 * 新增
		 */
		add,
		/**
		 * 修改
		 */
		edit,
		/**
		 * 审核
		 */
		check,
		/**
		 * 退回
		 */
		rejected,
		/**
		 * 移动
		 */
		move,
		/**
		 * 生成静态页
		 */
		createPage,
		/**
		 * 回收
		 */
		cycle,
		/**
		 * 归档
		 */
		pigeonhole,
		/**
		 * 出档
		 */
		reuse,
		/**
		 * 共享
		 */
		shared
	};
	
	public static final byte add = 0;
	public static final byte edit = 1;
	public static final byte check = 2;
	public static final byte rejected = 3;
	public static final byte move = 4;
	public static final byte createPage = 5;
	public static final byte cycle = 6;
	public static final byte pigeonhole = 7;
	public static final byte reuse = 8;
	public static final byte shared = 9;
	
	public JSONObject convertToJson(){
		JSONObject json = new JSONObject();
		if (getId()!=null) {
			json.put("id", getId());
		}else{
			json.put("id", "");
		}
		if (getOperateTime()!=null) {
			json.put("operateTime", DateUtils.parseDateToDateStr(getOperateTime()));
		}else{
			json.put("operateTime", "");
		}
		if (getOperateType()!=null) {
			json.put("operateType", getOperateType());
		}else{
			json.put("operateType", "");
		}
		if (getUser()!=null&&StringUtils.isNotBlank(getUser().getUsername())) {
			json.put("username", getUser().getUsername());
		}else{
			json.put("username", "");
		}
		return json;
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ContentRecord () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ContentRecord (Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ContentRecord (
		Long id,
		Content content,
		CmsUser user,
		java.util.Date operateTime,
		Byte operateType) {

		super (
			id,
			content,
			user,
			operateTime,
			operateType);
	}

/*[CONSTRUCTOR MARKER END]*/


}