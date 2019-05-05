package cn.onlov.cms.common.cms.manager.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsDirectiveTplDao;
import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsDirectiveTpl;
import cn.onlov.cms.common.cms.manager.assist.CmsDirectiveTplMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsDirectiveTplMngImpl implements CmsDirectiveTplMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<CmsDirectiveTpl> getList(int count){
		return dao.getList(count);
	}

	@Transactional(readOnly = true)
	public CmsDirectiveTpl findById(Integer id) {
		CmsDirectiveTpl entity = dao.findById(id);
		return entity;
	}

	public CmsDirectiveTpl save(CmsDirectiveTpl bean) {
		dao.save(bean);
		return bean;
	}

	public CmsDirectiveTpl update(CmsDirectiveTpl bean) {
		Updater<CmsDirectiveTpl> updater = new Updater<CmsDirectiveTpl>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsDirectiveTpl deleteById(Integer id) {
		CmsDirectiveTpl bean = dao.deleteById(id);
		return bean;
	}
	
	public CmsDirectiveTpl[] deleteByIds(Integer[] ids) {
		CmsDirectiveTpl[] beans = new CmsDirectiveTpl[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsDirectiveTplDao dao;

	@Autowired
	public void setDao(CmsDirectiveTplDao dao) {
		this.dao = dao;
	}
}