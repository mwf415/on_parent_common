package cn.onlov.on_cms_common.core.dao.impl;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.CmsRoleDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.CmsRole;

@Repository
public class CmsRoleDaoImpl extends HibernateBaseDao<CmsRole, Integer>
		implements CmsRoleDao {
	@SuppressWarnings("unchecked")
	public List<CmsRole> getList(Integer topLevel) {
		String hql = "from CmsRole bean ";
		Finder f=Finder.create(hql);
		if(topLevel!=null){
			f.append(" where bean.level<=:topLevel").setParam("topLevel", topLevel);
		}
		f.append(" order by bean.priority asc");
		return find(f);
	}

	public CmsRole findById(Integer id) {
		CmsRole entity = get(id);
		return entity;
	}

	public CmsRole save(CmsRole bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsRole deleteById(Integer id) {
		CmsRole entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsRole> getEntityClass() {
		return CmsRole.class;
	}
}