package cn.onlov.cms.common.core.dao;

import java.util.List;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.CmsOss;

public interface CmsOssDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsOss> getList();

	public CmsOss findById(Integer id);

	public CmsOss save(CmsOss bean);

	public CmsOss updateByUpdater(Updater<CmsOss> updater);

	public CmsOss deleteById(Integer id);
}