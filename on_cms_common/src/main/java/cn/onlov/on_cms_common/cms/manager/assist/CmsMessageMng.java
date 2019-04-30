package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsMessage;
import cn.onlov.on_cms_common.common.page.Pagination;

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