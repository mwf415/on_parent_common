package cn.onlov.cms.common.cms.manager.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsOriginDao;
import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.assist.CmsOrigin;
import cn.onlov.cms.common.cms.manager.assist.CmsOriginMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsOriginMngImpl implements CmsOriginMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<CmsOrigin> getList(String name){
		return dao.getList(name);
	}

	@Transactional(readOnly = true)
	public CmsOrigin findById(Integer id) {
		CmsOrigin entity = dao.findById(id);
		return entity;
	}

	public CmsOrigin save(CmsOrigin bean) {
		dao.save(bean);
		return bean;
	}

	public CmsOrigin update(CmsOrigin bean) {
		Updater<CmsOrigin> updater = new Updater<CmsOrigin>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsOrigin deleteById(Integer id) {
		CmsOrigin bean = dao.deleteById(id);
		return bean;
	}

	public CmsOrigin[] deleteByIds(Integer[] ids) {
		CmsOrigin[] beans = new CmsOrigin[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsOriginDao dao;

	@Autowired
	public void setDao(CmsOriginDao dao) {
		this.dao = dao;
	}
}