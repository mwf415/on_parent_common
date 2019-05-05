package cn.onlov.cms.common.cms.manager.assist;

import java.util.Date;
import java.util.List;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsMessage;

/**
 *江西金磊科技发展有限公司jeecms研发
 */
public interface CmsMessageMng {
	public Pagination getPage(Integer siteId, Integer sendUserId,
                              Integer receiverUserId, String title, Date sendBeginTime,
                              Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
                              int pageNo, int pageSize);
	
	public List<CmsMessage> getList(Integer siteId, Integer sendUserId,
                                    Integer receiverUserId, String title, Date sendBeginTime,
                                    Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
                                    Integer first, Integer count);

	public CmsMessage findById(Integer id);

	public CmsMessage save(CmsMessage bean);

	public CmsMessage update(CmsMessage bean);

	public CmsMessage deleteById(Integer id);

	public CmsMessage[] deleteByIds(Integer[] ids);
}