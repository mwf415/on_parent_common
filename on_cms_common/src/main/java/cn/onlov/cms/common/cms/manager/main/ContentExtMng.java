package cn.onlov.cms.common.cms.manager.main;

import cn.onlov.cms.common.cms.entity.main.Content;
import cn.onlov.cms.common.cms.entity.main.ContentExt;

public interface ContentExtMng {
	public ContentExt save(ContentExt ext, Content content);

	public ContentExt update(ContentExt ext);
}