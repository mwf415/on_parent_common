package cn.onlov.cms.common.core.manager.impl;

import java.util.List;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.core.manager.CmsConfigItemMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.onlov.cms.common.core.dao.CmsConfigItemDao;
import cn.onlov.cms.common.core.entity.CmsConfigItem;

@Service
@Transactional
public class CmsConfigItemMngImpl implements CmsConfigItemMng {
	@Transactional(readOnly = true)
	public List<CmsConfigItem> getList(Integer configId,Integer category) {
		return dao.getList(configId,category);
	}

	@Transactional(readOnly = true)
	public CmsConfigItem findById(Integer id) {
		CmsConfigItem entity = dao.findById(id);
		return entity;
	}

	public CmsConfigItem save(CmsConfigItem bean) {
		bean.init();
		dao.save(bean);
		return bean;
	}

	public void saveList(List<CmsConfigItem> list) {
		for (CmsConfigItem item : list) {
			save(item);
		}
	}

	public void updatePriority(Integer[] wids, Integer[] priority,
			String[] label) {
		CmsConfigItem item;
		for (int i = 0, len = wids.length; i < len; i++) {
			item = findById(wids[i]);
			item.setLabel(label[i]);
			item.setPriority(priority[i]);
		}
	}

	public CmsConfigItem update(CmsConfigItem bean) {
		Updater<CmsConfigItem> updater = new Updater<CmsConfigItem>(bean);
		CmsConfigItem entity = dao.updateByUpdater(updater);
		entity.emptyToNull();
		return entity;
	}

	public CmsConfigItem deleteById(Integer id) {
		CmsConfigItem bean = dao.deleteById(id);
		return bean;
	}

	public CmsConfigItem[] deleteByIds(Integer[] ids) {
		CmsConfigItem[] beans = new CmsConfigItem[ids.length];
		for (int i = 0, len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}
	private CmsConfigItemDao dao;

	@Autowired
	public void setDao(CmsConfigItemDao dao) {
		this.dao = dao;
	}


}