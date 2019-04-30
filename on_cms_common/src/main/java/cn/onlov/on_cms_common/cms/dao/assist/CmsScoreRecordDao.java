package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.assist.CmsScoreRecord;

public interface CmsScoreRecordDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<CmsScoreRecord> findListByContent(Integer contentId);
	
	public CmsScoreRecord findByScoreItemContent(Integer itemId,Integer contentId);

	public CmsScoreRecord findById(Integer id);

	public CmsScoreRecord save(CmsScoreRecord bean);

	public CmsScoreRecord updateByUpdater(Updater<CmsScoreRecord> updater);

	public CmsScoreRecord deleteById(Integer id);
}