package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.cms.entity.assist.CmsReceiverMessage;

/**
 *江西金磊科技发展有限公司jeecms研发
 */
public interface CmsReceiverMessageDao {

	public Pagination getPage(Integer siteId, Integer sendUserId,
                              Integer receiverUserId, String title, Date sendBeginTime,
                              Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
                              int pageNo, int pageSize);
	
	public List<CmsReceiverMessage> getList(Integer siteId, Integer sendUserId,
			Integer receiverUserId, String title, Date sendBeginTime,
			Date sendEndTime, Boolean status, Integer box, Boolean cacheable
			,Integer first,Integer count);
	
	public CmsReceiverMessage find(Integer messageId,Integer box);

	public CmsReceiverMessage findById(Integer id);

	public CmsReceiverMessage save(CmsReceiverMessage bean);

	public CmsReceiverMessage update(CmsReceiverMessage bean);

	public CmsReceiverMessage deleteById(Integer id);

	public CmsReceiverMessage[] deleteByIds(Integer[] ids);
}