package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsComment;
import cn.onlov.on_cms_common.cms.entity.assist.CmsCommentExt;

public interface CmsCommentExtMng {
	public CmsCommentExt save(String ip, String text, CmsComment comment);

	public CmsCommentExt update(CmsCommentExt bean);

	public int deleteByContentId(Integer contentId);
}