package cn.onlov.on_cms_common.core.entity;

import cn.onlov.on_cms_common.core.entity.base.BaseCmsUserExt;
import org.apache.commons.lang.StringUtils;

public class CmsUserExt extends BaseCmsUserExt {
	private static final long serialVersionUID = 1L;

	public void blankToNull() {
		// 将空串设置为null，便于前台处理。
		if (StringUtils.isBlank(getRealname())) {
			setRealname(null);
		}
		if (StringUtils.isBlank(getIntro())) {
			setIntro(null);
		}
		if (StringUtils.isBlank(getComefrom())) {
			setComefrom(null);
		}
		if (StringUtils.isBlank(getMobile())) {
			setMobile(null);
		}
		if (StringUtils.isBlank(getPhone())) {
			setPhone(null);
		}
		if (StringUtils.isBlank(getMsn())) {
			setMsn(null);
		}
		if (StringUtils.isBlank(getQq())) {
			setQq(null);
		}
		if(getTodayCommentTotal()==null){
			setTodayCommentTotal(0);
		}
		if(getTodayGuestbookTotal()==null){
			setTodayGuestbookTotal(0);
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsUserExt () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsUserExt (Integer id) {
		super(id);
	}

	/* [CONSTRUCTOR MARKER END] */

}