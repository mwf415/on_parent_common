package cn.onlov.cms.common.cms.manager.assist;

import java.util.List;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsSearchWords;
import net.sf.ehcache.Ehcache;

public interface CmsSearchWordsMng {
	public Pagination getPage(Integer siteId, String name, Integer recommend
			, Integer orderBy, int pageNo, int pageSize);

	public List<CmsSearchWords> getList(Integer siteId, String name,
                                        Integer recommend, Integer orderBy,
                                        Integer first, Integer count, boolean cacheable);
	
	public CmsSearchWords findById(Integer id);

	public CmsSearchWords save(CmsSearchWords bean);

	public CmsSearchWords update(CmsSearchWords bean);

	public CmsSearchWords deleteById(Integer id);
	
	public CmsSearchWords[] deleteByIds(Integer[] ids);
	
	public int freshCacheToDB(Ehcache cache);

}