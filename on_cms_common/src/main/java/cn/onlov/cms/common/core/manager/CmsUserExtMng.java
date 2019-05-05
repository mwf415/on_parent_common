package cn.onlov.cms.common.core.manager;

import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.core.entity.CmsUserExt;

public interface CmsUserExtMng {
	public CmsUserExt findById(Integer userId);
	
	public CmsUserExt save(CmsUserExt ext, CmsUser user);

	public CmsUserExt update(CmsUserExt ext, CmsUser user);
	
	public void clearDayCount();

	public int countByPhone(String mobile);
}