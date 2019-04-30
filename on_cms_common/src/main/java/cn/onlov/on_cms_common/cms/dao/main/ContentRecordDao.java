package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.main.ContentRecord;

public interface ContentRecordDao {
	public Pagination getPage(int pageNo, int pageSize);

	public ContentRecord findById(Long id);

	public ContentRecord save(ContentRecord bean);

	public ContentRecord updateByUpdater(Updater<ContentRecord> updater);

	public ContentRecord deleteById(Long id);

	public List<ContentRecord> getListByContentId(Integer contentId);
}