package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.assist.CmsAcquisitionReplace;

/**
 * 采集内容关键词替换接口
 * @author Administrator
 *
 */
public interface CmsAcquisitionReplaceDao {
	
	public CmsAcquisitionReplace save(CmsAcquisitionReplace bean);
	
	public CmsAcquisitionReplace updateByUpdater(Updater<CmsAcquisitionReplace> updater);
	
	public List<CmsAcquisitionReplace> getList(Integer acquisitionId);
}
