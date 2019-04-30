package cn.onlov.on_cms_common.core.dao;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsSms;

public interface CmsSmsDao {
public Pagination getPage(Byte source, int pageNo, int pageSize);
	
	public List<CmsSms> getList();

	public CmsSms findById(Integer id);

	public CmsSms save(CmsSms bean);

	public CmsSms updateByUpdater(Updater<CmsSms> updater);

	public CmsSms deleteById(Integer id);

	public CmsSms findBySource(Byte source);
}
