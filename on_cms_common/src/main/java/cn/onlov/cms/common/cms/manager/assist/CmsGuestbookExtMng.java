package cn.onlov.cms.common.cms.manager.assist;

import cn.onlov.cms.common.cms.entity.assist.CmsGuestbook;
import cn.onlov.cms.common.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookExtMng {
	public CmsGuestbookExt save(CmsGuestbookExt ext, CmsGuestbook guestbook);

	public CmsGuestbookExt update(CmsGuestbookExt ext);
}