package cn.onlov.on_cms_common.core.dao;

import java.util.Date;

import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsLog;

public interface CmsLogDao {
	public Pagination getPage(Integer category, Integer siteId, Integer userId,
                              String title, String ip, int pageNo, int pageSize);

	public CmsLog findById(Integer id);

	public CmsLog save(CmsLog bean);

	public CmsLog deleteById(Integer id);

	public int deleteBatch(Integer category, Integer siteId, Date before);
}