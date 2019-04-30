package cn.onlov.on_cms_common.cms.manager.assist.impl;

import java.util.List;

import cn.onlov.on_cms_common.cms.dao.assist.CmsPlugDao;
import cn.onlov.on_cms_common.cms.entity.assist.CmsPlug;
import cn.onlov.on_cms_common.cms.manager.assist.CmsPlugMng;
import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsPlugMngImpl implements CmsPlugMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	public List<CmsPlug> getList(String author, Boolean used){
		return dao.getList(author,used);
	}

	@Transactional(readOnly = true)
	public CmsPlug findById(Integer id) {
		CmsPlug entity = dao.findById(id);
		return entity;
	}
	
	@Transactional(readOnly = true)
	public CmsPlug findByPath(String plugPath){
		return dao.findByPath(plugPath);
	}

	public CmsPlug save(CmsPlug bean) {
		dao.save(bean);
		return bean;
	}

	public CmsPlug update(CmsPlug bean) {
		Updater<CmsPlug> updater = new Updater<CmsPlug>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsPlug deleteById(Integer id) {
		CmsPlug bean = dao.deleteById(id);
		return bean;
	}
	
	public CmsPlug[] deleteByIds(Integer[] ids) {
		CmsPlug[] beans = new CmsPlug[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsPlugDao dao;

	@Autowired
	public void setDao(CmsPlugDao dao) {
		this.dao = dao;
	}
}