package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.entity.main.ContentExt;

public interface ContentExtMng {
	public ContentExt save(ContentExt ext, Content content);

	public ContentExt update(ContentExt ext);
}