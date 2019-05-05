package cn.onlov.cms.common.core.manager.impl;

import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.manager.CmsSmsRecordMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.onlov.cms.common.core.dao.CmsSmsRecordDao;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.entity.CmsSms;
import cn.onlov.cms.common.core.entity.CmsSmsRecord;
import cn.onlov.cms.common.core.entity.CmsUser;

@Service
@Transactional
public class CmsSmsRecordMngImpl implements CmsSmsRecordMng {



	@Override
	public List<CmsSmsRecord> getList(Integer smsId) {
		return dao.getList(smsId);
	}

	@Override
	public CmsSmsRecord findById(Integer id) {
		return dao.findById(id);
	}
	
	@Override
	public List<CmsSmsRecord> findByPhone(String phone) {
		Date currentTime = new Date();
		long time = currentTime.getTime();
		time = time/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();
		Date startTime = new Date(time);
		Date endTime = new Date(time+24*60*60*1000-1);
		return dao.findByPhone(phone,startTime,endTime);
	}

	@Override
	public CmsSmsRecord save(CmsSmsRecord bean) {
		dao.save(bean);
		return bean;
	}

	@Override
	public CmsSmsRecord updateByUpdater(CmsSmsRecord bean) {
		Updater<CmsSmsRecord> updater = new Updater<CmsSmsRecord>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	@Override
	public CmsSmsRecord deleteById(Integer id) {
		CmsSmsRecord smsRecord = dao.deleteById(id);
		return smsRecord;
	}
	
	
	private CmsSmsRecordDao dao;
	@Autowired
	public void setDao(CmsSmsRecordDao dao) {
		this.dao = dao;
	}

	@Override
	public CmsSmsRecord[] deleteByIds(Integer[] ids) {
		CmsSmsRecord[] beans = new CmsSmsRecord[ids.length];
			for (int i = 0,len = ids.length; i < len; i++) {
				beans[i] = deleteById(ids[i]);
			}
			return beans;
	}

	@Override
	public Pagination getPage(Byte sms, int pageNo, int pageSize, String phone, Integer validateType,
                              String username, Date drawTimeBegin, Date drawTimeEnd) {
		Pagination page = dao.getPage(sms, pageNo, pageSize,phone,validateType,username,drawTimeBegin,drawTimeEnd);
		return page;
	}

	@Override
	public CmsSmsRecord save(CmsSms sms, String mobilePhone, Integer smsSendType, CmsSite site, CmsUser user) {
		 CmsSmsRecord record = new CmsSmsRecord();
		 record.setPhone(mobilePhone);
		 record.setSendTime(new Date());
		 record.setSms(sms);
		 record.setSite(site);
		 record.setValidateType(smsSendType);
		 record.setUser(user);
		 return save(record);
	}
}
