package cn.onlov.on_cms_common.core.manager;

import javax.servlet.http.HttpServletRequest;

import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsLog;
import cn.onlov.on_cms_common.core.entity.CmsUser;

public interface CmsLogMng {
	public Pagination getPage(Integer category, Integer siteId,
			String username, String title, String ip, int pageNo, int pageSize);

	public CmsLog findById(Integer id);

	public CmsLog operating(HttpServletRequest request, String title,
			String content);

	public CmsLog loginFailure(HttpServletRequest request,String content);

	public CmsLog loginSuccess(HttpServletRequest request, CmsUser user);

	public CmsLog save(CmsLog bean);

	public CmsLog deleteById(Integer id);

	public CmsLog[] deleteByIds(Integer[] ids);

	public int deleteBatch(Integer category, Integer siteId, Integer days);
}