package cn.onlov.on_cms_common.plug.store.manager.impl;

import cn.onlov.on_cms_common.plug.store.dao.PlugStoreConfigDao;
import cn.onlov.on_cms_common.plug.store.entity.PlugStoreConfig;
import cn.onlov.on_cms_common.plug.store.manager.PlugStoreConfigMng;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.common.security.encoder.PwdEncoder;

@Service
@Transactional
public class PlugStoreConfigMngImpl implements PlugStoreConfigMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}

	@Transactional(readOnly = true)
	public PlugStoreConfig findById(Integer id) {
		PlugStoreConfig entity = dao.findById(id);
		return entity;
	}
	
	@Transactional(readOnly = true)
	public PlugStoreConfig getDefault(){
		return findById(1);
	}

	public PlugStoreConfig save(PlugStoreConfig bean) {
		dao.save(bean);
		return bean;
	}

	public PlugStoreConfig update(PlugStoreConfig bean,String password) {
		Updater<PlugStoreConfig> updater = new Updater<PlugStoreConfig>(bean);
		if (StringUtils.isNotBlank(password)) {
			bean.setPassword(pwdEncoder.encodePassword(password));
		}else{
			updater.exclude("password");
		}
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public PlugStoreConfig deleteById(Integer id) {
		PlugStoreConfig bean = dao.deleteById(id);
		return bean;
	}
	
	public PlugStoreConfig[] deleteByIds(Integer[] ids) {
		PlugStoreConfig[] beans = new PlugStoreConfig[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private PlugStoreConfigDao dao;
	@Autowired
	private PwdEncoder pwdEncoder;

	@Autowired
	public void setDao(PlugStoreConfigDao dao) {
		this.dao = dao;
	}
}