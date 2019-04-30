package cn.onlov.on_cms_common.core.manager.impl;

import cn.onlov.on_cms_common.core.manager.CmsUserExtMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.dao.CmsUserExtDao;
import cn.onlov.on_cms_common.core.entity.CmsUser;
import cn.onlov.on_cms_common.core.entity.CmsUserExt;

@Service
@Transactional
public class CmsUserExtMngImpl implements CmsUserExtMng {
	@Transactional(readOnly = true)
	public CmsUserExt findById(Integer userId){
		return dao.findById(userId);
	}
	
	public CmsUserExt save(CmsUserExt ext, CmsUser user) {
		ext.blankToNull();
		ext.setUser(user);
		dao.save(ext);
		return ext;
	}

	public CmsUserExt update(CmsUserExt ext, CmsUser user) {
		CmsUserExt entity = dao.findById(user.getId());
		if (entity == null) {
			entity = save(ext, user);
			user.getUserExtSet().add(entity);
			return entity;
		} else {
			Updater<CmsUserExt> updater = new Updater<CmsUserExt>(ext);
		//	updater.include("gender");
		//	updater.include("birthday");
			ext = dao.updateByUpdater(updater);
			ext.blankToNull();
			return ext;
		}
	}
	
	public void clearDayCount(){
		dao.clearDayCount();
	}

	private CmsUserExtDao dao;

	@Autowired
	public void setDao(CmsUserExtDao dao) {
		this.dao = dao;
	}

	@Override
	public int countByPhone(String mobile) {
		return dao.countByPhone(mobile);
	}
}