package cn.onlov.cms.common.cms.manager.assist;

import java.util.List;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.cms.entity.assist.CmsGuestbook;
import cn.onlov.cms.common.cms.entity.assist.CmsGuestbookExt;

public interface CmsGuestbookMng {
	public Pagination getPage(Integer siteId, Integer ctgId, Integer ctgIds[],
                              Integer userId, Boolean recommend, Short checked,
                              boolean desc, boolean cacheable, int pageNo, int pageSize);

	public List<CmsGuestbook> getList(Integer siteId, Integer ctgId,
                                      Integer userId, Boolean recommend, Short checked, boolean desc,
                                      boolean cacheable, int first, int max);

	public CmsGuestbook findById(Integer id);

	public CmsGuestbook save(CmsGuestbook bean, CmsGuestbookExt ext,
			Integer ctgId, String ip);

	public CmsGuestbook save(CmsUser member, Integer siteId, Integer ctgId,
                             String ip, String title, String content, String email,
                             String phone, String qq);

	public CmsGuestbook update(CmsGuestbook bean, CmsGuestbookExt ext,
			Integer ctgId);

	public CmsGuestbook deleteById(Integer id);

	public CmsGuestbook[] deleteByIds(Integer[] ids);

	public CmsGuestbook[] checkByIds(Integer[] ids,CmsUser checkUser,Short checkStatus);
}