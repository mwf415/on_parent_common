package cn.onlov.on_cms_common.cms.entity.assist;

import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsFile;



public class CmsFile extends BaseCmsFile {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsFile () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsFile (String filePath) {
		super(filePath);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsFile (
		String filePath,
		boolean fileIsvalid) {

		super (
			filePath,
			fileIsvalid);
	}
	
	public Boolean getFileIsvalid(){
		return super.isFileIsvalid();
	}

/*[CONSTRUCTOR MARKER END]*/


}