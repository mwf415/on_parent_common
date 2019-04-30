package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.entity.main.ContentTxt;

public interface ContentTxtMng {
	public ContentTxt save(ContentTxt txt, Content content);

	public ContentTxt update(ContentTxt txt, Content content);
}