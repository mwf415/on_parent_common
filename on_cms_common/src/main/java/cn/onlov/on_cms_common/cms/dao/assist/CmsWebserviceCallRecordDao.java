package cn.onlov.on_cms_common.cms.dao.assist;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.assist.CmsWebserviceCallRecord;

public interface CmsWebserviceCallRecordDao {
	public Pagination getPage(int pageNo, int pageSize);

	public CmsWebserviceCallRecord findById(Integer id);

	public CmsWebserviceCallRecord save(CmsWebserviceCallRecord bean);

	public CmsWebserviceCallRecord updateByUpdater(Updater<CmsWebserviceCallRecord> updater);

	public CmsWebserviceCallRecord deleteById(Integer id);
}