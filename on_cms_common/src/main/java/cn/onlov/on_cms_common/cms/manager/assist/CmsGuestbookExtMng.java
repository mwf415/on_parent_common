package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsGuestbook;
import cn.onlov.on_cms_common.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook);

	public CmsGuestbookExt update(CmsGuestbookExt ext);
}