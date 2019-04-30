package cn.onlov.on_cms_common.cms.dao.assist.impl;

import java.util.List;

import cn.onlov.on_cms_common.cms.dao.assist.CmsAdvertisingSpaceDao;
import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.assist.CmsAdvertisingSpace;

@Repository
public class CmsAdvertisingSpaceDaoImpl extends
        HibernateBaseDao<CmsAdvertisingSpace, Integer> implements
        CmsAdvertisingSpaceDao {
	@SuppressWarnings("unchecked")
	public List<CmsAdvertisingSpace> getList(Integer siteId) {
		Finder f = Finder.create("from CmsAdvertisingSpace bean");
		if (siteId != null) {
			f.append(" where bean.site.id=:siteId");
			f.setParam("siteId", siteId);
		}
		return find(f);
	}

	public CmsAdvertisingSpace findById(Integer id) {
		CmsAdvertisingSpace entity = get(id);
		return entity;
	}

	public CmsAdvertisingSpace save(CmsAdvertisingSpace bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsAdvertisingSpace deleteById(Integer id) {
		CmsAdvertisingSpace entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsAdvertisingSpace> getEntityClass() {
		return CmsAdvertisingSpace.class;
	}
}