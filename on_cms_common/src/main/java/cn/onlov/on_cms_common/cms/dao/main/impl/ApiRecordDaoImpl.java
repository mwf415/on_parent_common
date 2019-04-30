package cn.onlov.on_cms_common.cms.dao.main.impl;

import java.util.List;

import cn.onlov.on_cms_common.cms.dao.main.ApiRecordDao;
import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.main.ApiRecord;

@Repository
public class ApiRecordDaoImpl extends HibernateBaseDao<ApiRecord, Long> implements ApiRecordDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}
	
	public ApiRecord findBySign(String sign,String appId){
		String hql="from ApiRecord bean where bean.sign=:sign and bean.apiAccount.appId=:appId";
		Finder f=Finder.create(hql).setParam("sign", sign).setParam("appId", appId);
		List<ApiRecord>li=find(f);
		if(li.size()>0){
			return li.get(0);
		}else{
			return null;
		}
	}

	public ApiRecord findById(Long id) {
		ApiRecord entity = get(id);
		return entity;
	}

	public ApiRecord save(ApiRecord bean) {
		getSession().save(bean);
		return bean;
	}

	public ApiRecord deleteById(Long id) {
		ApiRecord entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<ApiRecord> getEntityClass() {
		return ApiRecord.class;
	}
}