package cn.onlov.on_cms_common.cms.dao.assist;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.assist.CmsAcquisition;

public interface CmsAcquisitionDao {
	public List<CmsAcquisition> getList(Integer siteId);

	public CmsAcquisition findById(Integer id);

	public CmsAcquisition save(CmsAcquisition bean);

	public CmsAcquisition updateByUpdater(Updater<CmsAcquisition> updater);

	public CmsAcquisition deleteById(Integer id);

	public int countByChannelId(Integer channelId);

	public CmsAcquisition getStarted(Integer siteId);

	public Integer getMaxQueue(Integer siteId);

	public List<CmsAcquisition> getLargerQueues(Integer siteId, Integer queueNum);

	public CmsAcquisition popAcquFromQueue(Integer siteId);
}