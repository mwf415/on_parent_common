package cn.onlov.on_cms_common.core.manager;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.entity.CmsSms;
import cn.onlov.on_cms_common.core.entity.CmsSmsRecord;
import cn.onlov.on_cms_common.core.entity.CmsUser;

public interface CmsSmsRecordMng {

	public Pagination getPage(Byte smsId,int pageNo, int pageSize, String phone, Integer validateType, String username, Date drawTimeBegin, Date drawTimeEnd);
	
	public List<CmsSmsRecord> getList(Integer smsId);

	public CmsSmsRecord findById(Integer id);

	public CmsSmsRecord save(CmsSmsRecord bean);

	public CmsSmsRecord updateByUpdater(CmsSmsRecord bean);

	public CmsSmsRecord deleteById(Integer id);
	
	public List<CmsSmsRecord> findByPhone(String phone);

	public CmsSmsRecord[] deleteByIds(Integer[] idArr);

	public CmsSmsRecord save(CmsSms sms, String mobilePhone,Integer smsSendType,CmsSite site,CmsUser user);
}
