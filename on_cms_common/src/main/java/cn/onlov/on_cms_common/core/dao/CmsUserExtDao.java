package cn.onlov.on_cms_common.core.dao;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.entity.CmsUserExt;

public interface CmsUserExtDao {
	public CmsUserExt findById(Integer id);

	public CmsUserExt save(CmsUserExt bean);

	public CmsUserExt updateByUpdater(Updater<CmsUserExt> updater);
	
	public void clearDayCount();

	public int countByPhone(String mobile);
}