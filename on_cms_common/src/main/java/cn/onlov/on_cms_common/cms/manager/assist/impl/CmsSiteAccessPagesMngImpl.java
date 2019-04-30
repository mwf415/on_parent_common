package cn.onlov.on_cms_common.cms.manager.assist.impl;

import java.util.Date;

import cn.onlov.on_cms_common.cms.dao.assist.CmsSiteAccessPagesDao;
import cn.onlov.on_cms_common.cms.entity.assist.CmsSiteAccessPages;
import cn.onlov.on_cms_common.cms.manager.assist.CmsSiteAccessPagesMng;
import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tom
 */
@Service
@Transactional
public class CmsSiteAccessPagesMngImpl implements CmsSiteAccessPagesMng {

	public CmsSiteAccessPages findAccessPage(String sessionId, Integer pageIndex) {
		return dao.findAccessPage(sessionId,pageIndex);
	}
	
	public Pagination findPages(Integer siteId, Integer orderBy, Integer pageNo, Integer pageSize){
		return dao.findPages(siteId, orderBy,pageNo,pageSize);
	}

	public void clearByDate(Date date) {
		 dao.clearByDate(date);
	}
	
	public CmsSiteAccessPages save(CmsSiteAccessPages access) {
		return dao.save(access);
	}
	
	public CmsSiteAccessPages update(CmsSiteAccessPages access){
		Updater<CmsSiteAccessPages> updater = new Updater<CmsSiteAccessPages>(access);
		access = dao.updateByUpdater(updater);
		return access;
	}
	
	@Autowired
	private CmsSiteAccessPagesDao dao;

}
