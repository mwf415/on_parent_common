package cn.onlov.on_cms_common.cms.manager.assist;

import cn.onlov.on_cms_common.cms.entity.assist.CmsAccountDraw;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsUser;

import java.util.Date;
import java.util.List;

public interface CmsAccountDrawMng {
	
	public CmsAccountDraw draw(CmsUser user, Double amount, String applyAccount);
	
	public Double getAppliedSum(Integer userId);
	
	public Pagination getPage(Integer userId, Short applyStatus,
                              Date applyTimeBegin, Date applyTimeEnd, int pageNo, int pageSize);
	
	public List<CmsAccountDraw> getList(Integer userId,Short applyStatus,
			Date applyTimeBegin,Date applyTimeEnd,Integer first,Integer count);

	public CmsAccountDraw findById(Integer id);

	public CmsAccountDraw save(CmsAccountDraw bean);

	public CmsAccountDraw update(CmsAccountDraw bean);

	public CmsAccountDraw deleteById(Integer id);
	
	public CmsAccountDraw[] deleteByIds(Integer[] ids);
}