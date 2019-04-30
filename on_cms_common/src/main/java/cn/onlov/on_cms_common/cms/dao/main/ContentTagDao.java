package cn.onlov.on_cms_common.cms.dao.main;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.main.ContentTag;

public interface ContentTagDao {
	public List<ContentTag> getList(Integer first,Integer count, boolean cacheable);

	public Pagination getPage(String name, int pageNo, int pageSize,
                              boolean cacheable);

	public ContentTag findById(Integer id);

	public ContentTag findByName(String name, boolean cacheable);

	public ContentTag save(ContentTag bean);

	public ContentTag updateByUpdater(Updater<ContentTag> updater);

	public ContentTag deleteById(Integer id);

	public int deleteContentRef(Integer id);

	public int countContentRef(Integer id);
}