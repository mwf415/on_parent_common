package cn.onlov.on_cms_common.cms.dao.assist.impl;

import java.util.List;

import cn.onlov.on_cms_common.cms.dao.assist.CmsTaskDao;
import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.assist.CmsTask;

@Repository
public class CmsTaskDaoImpl extends HibernateBaseDao<CmsTask, Integer> implements CmsTaskDao {
	public Pagination getPage(Integer siteId, int pageNo, int pageSize) {
		Finder f=Finder.create("from CmsTask task where task.site.id=:siteId").setParam("siteId", siteId);
		Pagination page = find(f, pageNo, pageSize);
		return page;
	}
	
	@SuppressWarnings("unchecked")
	public List<CmsTask> getList(){
		Finder f=Finder.create("from CmsTask");
		return find(f);
	}

	public CmsTask findById(Integer id) {
		CmsTask entity = get(id);
		return entity;
	}

	public CmsTask save(CmsTask bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsTask deleteById(Integer id) {
		CmsTask entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CmsTask> getEntityClass() {
		return CmsTask.class;
	}
}