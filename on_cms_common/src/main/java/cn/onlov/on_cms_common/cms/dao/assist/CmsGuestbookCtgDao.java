package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.assist.CmsGuestbookCtg;

public interface CmsGuestbookCtgDao {
	public List<CmsGuestbookCtg> getList(Integer siteId);

	public CmsGuestbookCtg findById(Integer id);

	public CmsGuestbookCtg save(CmsGuestbookCtg bean);

	public CmsGuestbookCtg updateByUpdater(Updater<CmsGuestbookCtg> updater);

	public CmsGuestbookCtg deleteById(Integer id);
}