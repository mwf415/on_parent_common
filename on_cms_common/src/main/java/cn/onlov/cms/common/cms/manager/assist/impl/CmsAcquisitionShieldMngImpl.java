package cn.onlov.cms.common.cms.manager.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsAcquisitionShieldDao;
import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionShield;
import cn.onlov.cms.common.cms.manager.assist.CmsAcquisitionShieldMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmsAcquisitionShieldMngImpl implements CmsAcquisitionShieldMng {

	@Override
	public CmsAcquisitionShield save(CmsAcquisitionShield bean) {
		return cmsAcquisitionShieldDao.save(bean);
	}

	@Override
	public CmsAcquisitionShield updateByUpdater(Updater<CmsAcquisitionShield> updater) {
		return cmsAcquisitionShieldDao.updateByUpdater(updater);
	}
	
	@Override
	public List<CmsAcquisitionShield> getList(Integer acquisitionId) {		
		return cmsAcquisitionShieldDao.getList(acquisitionId);
	}
	
	@Autowired
	private CmsAcquisitionShieldDao cmsAcquisitionShieldDao;

}
