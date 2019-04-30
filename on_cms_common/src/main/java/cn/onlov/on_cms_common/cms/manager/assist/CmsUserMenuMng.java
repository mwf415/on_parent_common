package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsUserMenu;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface CmsUserMenuMng {
	public Pagination getPage(Integer userId, int pageNo, int pageSize);
	
	public List<CmsUserMenu> getList(Integer userId, int cout);

	public CmsUserMenu findById(Integer id);

	public CmsUserMenu save(CmsUserMenu bean);

	public CmsUserMenu update(CmsUserMenu bean);

	public CmsUserMenu deleteById(Integer id);
	
	public CmsUserMenu[] deleteByIds(Integer[] ids);
}