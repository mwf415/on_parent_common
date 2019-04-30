package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.assist.CmsGuestbook;

public interface CmsGuestbookDao {
	public Pagination getPage(Integer siteId, Integer ctgId, Integer ctgIds[],
                              Integer userId, Boolean recommend, Short checked, boolean desc,
                              boolean cacheable, int pageNo, int pageSize);
	
	public List<CmsGuestbook> getList(Integer siteId, Integer ctgId,
			Integer userId,Boolean recommend, Short checked, boolean desc,
			boolean cacheable, int first, int max);

	public CmsGuestbook findById(Integer id);

	public CmsGuestbook save(CmsGuestbook bean);

	public CmsGuestbook updateByUpdater(Updater<CmsGuestbook> updater);

	public CmsGuestbook deleteById(Integer id);
}