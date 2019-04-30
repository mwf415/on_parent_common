package cn.onlov.on_cms_common.cms.manager.main;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.entity.main.ContentCharge;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface ContentChargeMng {
	
	public List<ContentCharge> getList(String contentTitle, Integer authorUserId,
                                       Date buyTimeBegin, Date buyTimeEnd, int orderBy, Integer first, Integer count);
	
	public Pagination getPage(String contentTitle, Integer authorUserId,
                              Date buyTimeBegin, Date buyTimeEnd,
                              int orderBy, int pageNo, int pageSize);
	
	public ContentCharge save(Double chargeAmount, Short charge,
			Boolean rewardPattern,Double rewardRandomMin,Double rewardRandomMax,
			Content content);
	
	public void afterContentUpdate(Content bean,Short charge,Double chargeAmount,
			Boolean rewardPattern,Double rewardRandomMin,Double rewardRandomMax);

	public ContentCharge update(ContentCharge charge);
	
	public ContentCharge afterUserPay(Double payAmout, Content content);
}