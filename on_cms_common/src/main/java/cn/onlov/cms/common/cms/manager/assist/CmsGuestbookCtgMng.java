package cn.onlov.cms.common.cms.manager.assist;

import java.util.List;

import cn.onlov.cms.common.cms.entity.assist.CmsGuestbookCtg;

public interface CmsGuestbookCtgMng {
	public List<CmsGuestbookCtg> getList(Integer siteId);

	public CmsGuestbookCtg findById(Integer id);

	public CmsGuestbookCtg save(CmsGuestbookCtg bean);

	public CmsGuestbookCtg update(CmsGuestbookCtg bean);

	public CmsGuestbookCtg deleteById(Integer id);

	public CmsGuestbookCtg[] deleteByIds(Integer[] ids);
}