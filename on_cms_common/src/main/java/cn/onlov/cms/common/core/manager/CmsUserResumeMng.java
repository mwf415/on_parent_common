package cn.onlov.cms.common.core.manager;

import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.core.entity.CmsUserResume;

public interface CmsUserResumeMng {
	public CmsUserResume save(CmsUserResume ext, CmsUser user);

	public CmsUserResume update(CmsUserResume ext, CmsUser user);
}