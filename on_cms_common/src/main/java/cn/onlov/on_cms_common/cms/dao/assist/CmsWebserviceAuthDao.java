package cn.onlov.on_cms_common.cms.dao.assist;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.assist.CmsWebserviceAuth;

public interface CmsWebserviceAuthDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public CmsWebserviceAuth findByUsername(String username);

	public CmsWebserviceAuth findById(Integer id);

	public CmsWebserviceAuth save(CmsWebserviceAuth bean);

	public CmsWebserviceAuth updateByUpdater(Updater<CmsWebserviceAuth> updater);

	public CmsWebserviceAuth deleteById(Integer id);
}