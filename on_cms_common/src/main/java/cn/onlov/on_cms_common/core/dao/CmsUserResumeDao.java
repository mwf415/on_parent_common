package cn.onlov.on_cms_common.core.dao;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.entity.CmsUserResume;

public interface CmsUserResumeDao {
	public CmsUserResume findById(Integer id);

	public CmsUserResume save(CmsUserResume bean);

	public CmsUserResume updateByUpdater(Updater<CmsUserResume> updater);
}