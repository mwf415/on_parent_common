package cn.onlov.on_cms_common.core.manager.impl;

import cn.onlov.on_cms_common.core.manager.CmsSiteCompanyMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.dao.CmsSiteCompanyDao;
import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.entity.CmsSiteCompany;

@Service
@Transactional
public class CmsSiteCompanyMngImpl implements CmsSiteCompanyMng {
	public CmsSiteCompany save(CmsSite site,CmsSiteCompany bean) {
		site.setSiteCompany(bean);
		bean.setSite(site);
		dao.save(bean);
		return bean;
	}

	public CmsSiteCompany update(CmsSiteCompany bean) {
		Updater<CmsSiteCompany> updater = new Updater<CmsSiteCompany>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	private CmsSiteCompanyDao dao;

	@Autowired
	public void setDao(CmsSiteCompanyDao dao) {
		this.dao = dao;
	}
}