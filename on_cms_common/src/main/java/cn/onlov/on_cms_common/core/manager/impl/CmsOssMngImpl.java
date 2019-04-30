package cn.onlov.on_cms_common.core.manager.impl;

import java.util.List;

import cn.onlov.on_cms_common.core.manager.CmsOssMng;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.dao.CmsOssDao;
import cn.onlov.on_cms_common.core.entity.CmsOss;

@Service
@Transactional
public class CmsOssMngImpl implements CmsOssMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<CmsOss> getList(){
		return dao.getList();
	}

	@Transactional(readOnly = true)
	public CmsOss findById(Integer id) {
		CmsOss entity = dao.findById(id);
		return entity;
	}

	public CmsOss save(CmsOss bean) {
		dao.save(bean);
		return bean;
	}

	public CmsOss update(CmsOss bean) {
		Updater<CmsOss> updater = new Updater<CmsOss>(bean);
		if(StringUtils.isBlank(bean.getSecretId())){
			updater.exclude("secretId");
		}
		if(StringUtils.isBlank(bean.getAppKey())){
			updater.exclude("appKey");
		}
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	public CmsOss deleteById(Integer id) {
		CmsOss bean = dao.deleteById(id);
		return bean;
	}
	
	public CmsOss[] deleteByIds(Integer[] ids) {
		CmsOss[] beans = new CmsOss[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}

	private CmsOssDao dao;

	@Autowired
	public void setDao(CmsOssDao dao) {
		this.dao = dao;
	}
}