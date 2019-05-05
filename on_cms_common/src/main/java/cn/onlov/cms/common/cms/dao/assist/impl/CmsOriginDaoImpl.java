package cn.onlov.cms.common.cms.dao.assist.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.assist.CmsOriginDao;
import cn.onlov.cms.common.common.hibernate4.Finder;
import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import cn.onlov.cms.common.common.page.Pagination;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import cn.onlov.cms.common.cms.entity.assist.CmsOrigin;

@Repository
public class CmsOriginDaoImpl extends HibernateBaseDao<CmsOrigin, Integer> implements CmsOriginDao {
	public Pagination getPage(int pageNo, int pageSize) {
		Finder f=Finder.create("from CmsOrigin origin");
		Pagination page = find(f, pageNo, pageSize);
		return page;
	}
	
	@SuppressWarnings("unchecked")
	public List<CmsOrigin> getList(String name){
		Finder f=Finder.create("from CmsOrigin origin ");
		if(StringUtils.isNotBlank(name)){
			f.append(" where origin.name like :name").setParam("name", "%"+name+"%");
		}
		return find(f);
	}

	public CmsOrigin findById(Integer id) {
		CmsOrigin entity = get(id);
		return entity;
	}

	public CmsOrigin save(CmsOrigin bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsOrigin deleteById(Integer id) {
		CmsOrigin entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}
	
	@Override
	protected Class<CmsOrigin> getEntityClass() {
		return CmsOrigin.class;
	}
}