package cn.onlov.on_cms_common.cms.dao.assist;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsJobApply;

public interface CmsJobApplyDao {
	public Pagination getPage(Integer userId, Integer contentId,
                              Integer siteId, boolean cacheable, String title, int pageNo, int pageSize);
	
	public List<CmsJobApply> getList(Integer userId,Integer contentId,Integer siteId,
			boolean cacheable,String title,Integer first, Integer count);

	public CmsJobApply findById(Integer id);

	public CmsJobApply save(CmsJobApply bean);

	public CmsJobApply updateByUpdater(Updater<CmsJobApply> updater);

	public CmsJobApply deleteById(Integer id);
}