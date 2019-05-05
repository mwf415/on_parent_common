package cn.onlov.cms.common.cms.manager.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsJobApplyDao;
import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsJobApply;
import cn.onlov.cms.common.cms.manager.assist.CmsJobApplyMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsJobApplyMngImpl implements CmsJobApplyMng {
	@Transactional(readOnly = true)
	public Pagination getPage(Integer userId, Integer contentId, Integer siteId, boolean cacheable, String title, int pageNo, int pageSize) {
		Pagination page = dao.getPage(userId,contentId,siteId,cacheable,title,pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<CmsJobApply> getList(Integer userId, Integer contentId, Integer siteId,
                                     boolean cacheable, String title, Integer first, Integer count){
		return dao.getList(userId,contentId,siteId,cacheable,title,first, count);
	}

	@Transactional(readOnly = true)
	public CmsJobApply findById(Integer id) {
		CmsJobApply entity = dao.findById(id);
		return entity;
	}

	public CmsJobApply save(CmsJobApply bean) {
		dao.save(bean);
		return bean;
	}

	public CmsJobApply update(CmsJobApply bean) {
		Updater<CmsJobApply> updater = new Updater<CmsJobApply>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsJobApply deleteById(Integer id) {
		CmsJobApply bean = dao.deleteById(id);
		return bean;
	}
	
	public CmsJobApply[] deleteByIds(Integer[] ids) {
		CmsJobApply[] beans = new CmsJobApply[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsJobApplyDao dao;

	@Autowired
	public void setDao(CmsJobApplyDao dao) {
		this.dao = dao;
	}
}