package cn.onlov.on_cms_common.core.dao;

import java.util.Date;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsUserAccount;

public interface CmsUserAccountDao {
	
	public Pagination getPage(String username, Date drawTimeBegin, Date drawTimeEnd,
                              int orderBy, int pageNo, int pageSize);
	
	public CmsUserAccount findById(Integer id);

	public CmsUserAccount save(CmsUserAccount bean);

	public CmsUserAccount updateByUpdater(Updater<CmsUserAccount> updater);
}