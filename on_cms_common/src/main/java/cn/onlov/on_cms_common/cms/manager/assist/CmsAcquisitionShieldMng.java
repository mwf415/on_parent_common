package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsAcquisitionShield;
import cn.onlov.on_cms_common.common.hibernate4.Updater;

/**
 * 采集管理批量替换MANGER
 * @author Administrator
 *
 */
public interface CmsAcquisitionShieldMng {
	
	public CmsAcquisitionShield save(CmsAcquisitionShield bean);
	
	public CmsAcquisitionShield updateByUpdater(Updater<CmsAcquisitionShield> updater);
	
	public List<CmsAcquisitionShield> getList(Integer acquisitionId);
}
