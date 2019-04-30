package cn.onlov.on_cms_common.core.manager;

import cn.onlov.on_cms_common.core.entity.CmsUser;
import cn.onlov.on_cms_common.core.entity.CmsUserResume;

public interface CmsUserResumeMng {
	public CmsUserResume save(CmsUserResume ext, CmsUser user);

	public CmsUserResume update(CmsUserResume ext, CmsUser user);
}