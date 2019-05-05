package cn.onlov.cms.common.core.dao;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.core.entity.CmsUserExt;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
	
	public void clearDayCount();

	public int countByPhone(String mobile);
}