package cn.onlov.cms.common.core.manager;

import java.util.Date;
import java.util.List;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.entity.CmsSms;
import cn.onlov.cms.common.core.entity.CmsSmsRecord;
import cn.onlov.cms.common.core.entity.CmsUser;

public interface CmsSmsRecordMng {

	public Pagination getPage(Byte smsId, int pageNo, int pageSize, String phone, Integer validateType, String username, Date drawTimeBegin, Date drawTimeEnd);
	
	public List<CmsSmsRecord> getList(Integer smsId);

	public CmsSmsRecord findById(Integer id);

	public CmsSmsRecord save(CmsSmsRecord bean);

	public CmsSmsRecord updateByUpdater(CmsSmsRecord bean);

	public CmsSmsRecord deleteById(Integer id);
	
	public List<CmsSmsRecord> findByPhone(String phone);

	public CmsSmsRecord[] deleteByIds(Integer[] idArr);

	public CmsSmsRecord save(CmsSms sms, String mobilePhone,Integer smsSendType,CmsSite site,CmsUser user);
}
