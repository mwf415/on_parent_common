package cn.onlov.cms.common.core.dao;

import java.util.List;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.CmsSms;

public interface CmsSmsDao {
public Pagination getPage(Byte source, int pageNo, int pageSize);
	
	public List<CmsSms> getList();

	public CmsSms findById(Integer id);

	public CmsSms save(CmsSms bean);

	public CmsSms updateByUpdater(Updater<CmsSms> updater);

	public CmsSms deleteById(Integer id);

	public CmsSms findBySource(Byte source);
}
