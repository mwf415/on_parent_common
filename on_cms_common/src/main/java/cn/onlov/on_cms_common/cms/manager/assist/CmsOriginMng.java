package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsOrigin;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface CmsOriginMng {
	public Pagination getPage(int pageNo, int pageSize);

	public List<CmsOrigin> getList(String name);
	
	public CmsOrigin findById(Integer id);

	public CmsOrigin save(CmsOrigin bean);

	public CmsOrigin update(CmsOrigin bean);

	public CmsOrigin deleteById(Integer id);
	
	public CmsOrigin[] deleteByIds(Integer[] ids);

}