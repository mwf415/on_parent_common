package cn.onlov.on_cms_common.core.dao;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsSmsRecord;

public interface CmsSmsRecordDao {
	public Pagination getPage(Byte smsId, int pageNo, int pageSize, String phone, Integer validateType, String username, Date drawTimeBegin, Date drawTimeEnd);
	
	public List<CmsSmsRecord> getList(Integer smsId);

	public CmsSmsRecord findById(Integer id);

	public CmsSmsRecord save(CmsSmsRecord bean);

	public CmsSmsRecord updateByUpdater(Updater<CmsSmsRecord> updater);

	public CmsSmsRecord deleteById(Integer id);

	public List<CmsSmsRecord> findByPhone(String phone,Date startTime,Date endTime);
}
