package cn.onlov.on_cms_common.core.dao.impl;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.CmsGroupDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.CmsGroup;

@Repository
public class CmsGroupDaoImpl extends HibernateBaseDao<CmsGroup, Integer>
		implements CmsGroupDao {
	@SuppressWarnings("unchecked")
	public List<CmsGroup> getList() {
		String hql = "from CmsGroup bean order by bean.priority asc,bean.id asc";
		return find(hql);
	}

	public CmsGroup getRegDef() {
		String hql = "from CmsGroup bean where bean.regDef=true";
		return (CmsGroup) findUnique(hql);
	}

	public CmsGroup findById(Integer id) {
		CmsGroup entity = get(id);
		return entity;
	}
	
	public CmsGroup findByName(String name){
		String hql = "from CmsGroup bean where bean.name=:name";
		Finder f=Finder.create(hql).setParam("name", name);
		List<CmsGroup>list=find(f);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}
	

	public CmsGroup save(CmsGroup bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsGroup deleteById(Integer id) {
		CmsGroup entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsGroup> getEntityClass() {
		return CmsGroup.class;
	}
}