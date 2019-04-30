package cn.onlov.on_cms_common.cms.dao.assist.impl;

import cn.onlov.on_cms_common.cms.dao.assist.CmsWebserviceCallRecordDao;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.assist.CmsWebserviceCallRecord;

@Repository
public class CmsWebserviceCallRecordDaoImpl extends HibernateBaseDao<CmsWebserviceCallRecord, Integer> implements CmsWebserviceCallRecordDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Criteria crit = createCriteria();
		Pagination page = findByCriteria(crit, pageNo, pageSize);
		return page;
	}

	public CmsWebserviceCallRecord findById(Integer id) {
		CmsWebserviceCallRecord entity = get(id);
		return entity;
	}

	public CmsWebserviceCallRecord save(CmsWebserviceCallRecord bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsWebserviceCallRecord deleteById(Integer id) {
		CmsWebserviceCallRecord entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CmsWebserviceCallRecord> getEntityClass() {
		return CmsWebserviceCallRecord.class;
	}
}