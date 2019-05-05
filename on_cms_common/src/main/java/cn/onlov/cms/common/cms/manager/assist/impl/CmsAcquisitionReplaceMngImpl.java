package cn.onlov.cms.common.cms.manager.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsAcquisitionReplaceDao;
import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionReplace;
import cn.onlov.cms.common.cms.manager.assist.CmsAcquisitionReplaceMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsAcquisitionReplaceMngImpl implements CmsAcquisitionReplaceMng {

	@Override
	public CmsAcquisitionReplace save(CmsAcquisitionReplace bean) {
		return cmsAcquisitionReplaceDao.save(bean);
	}

	@Override
	public CmsAcquisitionReplace updateByUpdater(Updater<CmsAcquisitionReplace> updater) {
		return cmsAcquisitionReplaceDao.updateByUpdater(updater);
	}
	
	@Transactional(readOnly = true)
	public List<CmsAcquisitionReplace> getList(Integer acquisitionId) {
		return cmsAcquisitionReplaceDao.getList(acquisitionId);
	}

	@Autowired
	private CmsAcquisitionReplaceDao cmsAcquisitionReplaceDao;

	
}
