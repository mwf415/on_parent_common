package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsScoreRecord;



public class CmsScoreRecord extends BaseCmsScoreRecord {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsScoreRecord () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsScoreRecord (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsScoreRecord (
		Integer id,
		CmsScoreItem item,
		Content content,
		Integer count) {

		super (
			id,
			item,
			content,
			count);
	}

/*[CONSTRUCTOR MARKER END]*/


}