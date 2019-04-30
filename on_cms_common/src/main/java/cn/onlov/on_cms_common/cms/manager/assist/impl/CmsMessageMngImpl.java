package cn.onlov.on_cms_common.cms.manager.assist.impl;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.cms.dao.assist.CmsMessageDao;
import cn.onlov.on_cms_common.cms.entity.assist.CmsMessage;
import cn.onlov.on_cms_common.cms.manager.assist.CmsMessageMng;
import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *江西金磊科技发展有限公司jeecms研发
 */
@Service
@Transactional
public class CmsMessageMngImpl implements CmsMessageMng {

	@Transactional(readOnly=true)
	public Pagination getPage(Integer siteId, Integer sendUserId,
                              Integer receiverUserId, String title, Date sendBeginTime,
                              Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
                              int pageNo, int pageSize) {
		return dao.getPage(siteId, sendUserId, receiverUserId, title,
				sendBeginTime, sendEndTime, status, box, cacheable, pageNo,
				pageSize);
	}
	
	@Transactional(readOnly=true)
	public List<CmsMessage> getList(Integer siteId, Integer sendUserId,
                                    Integer receiverUserId, String title, Date sendBeginTime,
                                    Date sendEndTime, Boolean status, Integer box, Boolean cacheable,
                                    Integer first, Integer count){
		return dao.getList(siteId, sendUserId, receiverUserId, title,
				sendBeginTime, sendEndTime, status, box, cacheable, first,
				count);
	}

	@Transactional(readOnly=true)
	public CmsMessage findById(Integer id) {
		return dao.findById(id);
	}

	public CmsMessage save(CmsMessage bean) {
		return dao.save(bean);
	}

	public CmsMessage update(CmsMessage bean) {
		Updater<CmsMessage> updater = new Updater<CmsMessage>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsMessage deleteById(Integer id) {
		return dao.deleteById(id);
	}

	public CmsMessage[] deleteByIds(Integer[] ids) {
		return dao.deleteByIds(ids);
	}

	@Autowired
	private CmsMessageDao dao;

}
