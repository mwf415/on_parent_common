package cn.onlov.cms.common.cms.manager.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsAdvertisingSpaceDao;
import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.cms.entity.assist.CmsAdvertisingSpace;
import cn.onlov.cms.common.cms.manager.assist.CmsAdvertisingSpaceMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsAdvertisingSpaceMngImpl implements CmsAdvertisingSpaceMng {
	@Transactional(readOnly = true)
	public List<CmsAdvertisingSpace> getList(Integer siteId) {
		return dao.getList(siteId);
	}

	@Transactional(readOnly = true)
	public CmsAdvertisingSpace findById(Integer id) {
		CmsAdvertisingSpace entity = dao.findById(id);
		return entity;
	}

	public CmsAdvertisingSpace save(CmsAdvertisingSpace bean) {
		dao.save(bean);
		return bean;
	}

	public CmsAdvertisingSpace update(CmsAdvertisingSpace bean) {
		Updater<CmsAdvertisingSpace> updater = new Updater<CmsAdvertisingSpace>(
				bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsAdvertisingSpace deleteById(Integer id) {
		CmsAdvertisingSpace bean = dao.deleteById(id);
		return bean;
	}

	public CmsAdvertisingSpace[] deleteByIds(Integer[] ids) {
		CmsAdvertisingSpace[] beans = new CmsAdvertisingSpace[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsAdvertisingSpaceDao dao;

	@Autowired
	public void setDao(CmsAdvertisingSpaceDao dao) {
		this.dao = dao;
	}
}