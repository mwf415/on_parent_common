package cn.onlov.cms.common.core.dao;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.core.entity.CmsUserResume;

public interface CmsUserResumeDao {
	public CmsUserResume findById(Integer id);

	public CmsUserResume save(CmsUserResume bean);

	public CmsUserResume updateByUpdater(Updater<CmsUserResume> updater);
}