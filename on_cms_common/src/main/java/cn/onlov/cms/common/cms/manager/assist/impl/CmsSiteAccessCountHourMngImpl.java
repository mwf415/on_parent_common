package cn.onlov.cms.common.cms.manager.assist.impl;

import java.util.Date;
import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsSiteAccessCountHourDao;
import cn.onlov.cms.common.cms.dao.assist.CmsSiteAccessDao;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.manager.CmsSiteMng;
import cn.onlov.cms.common.cms.entity.assist.CmsSiteAccessCountHour;
import cn.onlov.cms.common.cms.manager.assist.CmsSiteAccessCountHourMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsSiteAccessCountHourMngImpl implements CmsSiteAccessCountHourMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public List<CmsSiteAccessCountHour> getList(Date date){
		return dao.getList(date);
	}
	
	public void statisticCount(Date date, Integer siteId){
		List<Object[]> statisTicData = cmsAccessDao.statisticByDayGroupByHour(date, siteId);
		CmsSite site=siteMng.findById(siteId);
		for (Object[]  d: statisTicData) {
			CmsSiteAccessCountHour bean = new CmsSiteAccessCountHour();
			bean.setSite(site);
			bean.setAccessDate(date);
			Long pv = (Long) d[0];
			Long ip = (Long) d[1];
			Long visitor = (Long) d[2];
			Integer hour = (Integer) d[3];
			bean.setHourUv(visitor);
			bean.setHourPv(pv);
			bean.setHourIp(ip);
			bean.setAccessHour(hour);
			save(bean);
		}
	}

	@Transactional(readOnly = true)
	public CmsSiteAccessCountHour findById(Integer id) {
		CmsSiteAccessCountHour entity = dao.findById(id);
		return entity;
	}

	public CmsSiteAccessCountHour save(CmsSiteAccessCountHour bean) {
		dao.save(bean);
		return bean;
	}

	
	private CmsSiteAccessCountHourDao dao;
	@Autowired
	private CmsSiteAccessDao cmsAccessDao;
	@Autowired
	private CmsSiteMng siteMng;

	@Autowired
	public void setDao(CmsSiteAccessCountHourDao dao) {
		this.dao = dao;
	}
}