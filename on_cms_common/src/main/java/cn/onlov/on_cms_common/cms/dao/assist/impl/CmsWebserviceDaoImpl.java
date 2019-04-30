package cn.onlov.on_cms_common.cms.dao.assist.impl;

import java.util.List;

import cn.onlov.on_cms_common.cms.dao.assist.CmsWebserviceDao;
import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.assist.CmsWebservice;

@Repository
public class CmsWebserviceDaoImpl extends HibernateBaseDao<CmsWebservice, Integer> implements CmsWebserviceDao {
	public Pagination getPage(int pageNo, int pageSize) {
		String hql="from CmsWebservice bean";
		Finder f=Finder.create(hql);
		return find(f, pageNo, pageSize);
	}
	
	@SuppressWarnings("unchecked")
	public List<CmsWebservice> getList(String type){
		String hql="from CmsWebservice bean where bean.type=:type";
		Finder f =Finder.create(hql).setParam("type", type);
		f.setCacheable(true);
		return find(f);
	}

	public CmsWebservice findById(Integer id) {
		CmsWebservice entity = get(id);
		return entity;
	}

	public CmsWebservice save(CmsWebservice bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsWebservice deleteById(Integer id) {
		CmsWebservice entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CmsWebservice> getEntityClass() {
		return CmsWebservice.class;
	}
}