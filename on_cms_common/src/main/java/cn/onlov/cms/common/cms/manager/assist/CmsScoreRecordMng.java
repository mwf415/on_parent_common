package cn.onlov.cms.common.cms.manager.assist;

import java.util.Map;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsScoreRecord;

public interface CmsScoreRecordMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public Map<String,String> viewContent(Integer contentId);

	public int contentScore(Integer contentId,Integer itemId);
	
	public CmsScoreRecord findByScoreItemContent(Integer itemId, Integer contentId);

	public CmsScoreRecord findById(Integer id);

	public CmsScoreRecord save(CmsScoreRecord bean);

	public CmsScoreRecord update(CmsScoreRecord bean);

	public CmsScoreRecord deleteById(Integer id);
	
	public CmsScoreRecord[] deleteByIds(Integer[] ids);
}