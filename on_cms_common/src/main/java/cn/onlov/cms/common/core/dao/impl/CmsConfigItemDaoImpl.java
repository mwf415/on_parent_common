package cn.onlov.cms.common.core.dao.impl;

import java.util.List;

import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import cn.onlov.cms.common.core.entity.CmsConfigItem;
import cn.onlov.cms.common.core.dao.CmsConfigItemDao;
import org.springframework.stereotype.Repository;

@Repository
public class CmsConfigItemDaoImpl extends
        HibernateBaseDao<CmsConfigItem, Integer> implements CmsConfigItemDao {
	@SuppressWarnings("unchecked")
	public List<CmsConfigItem> getList(Integer configId, Integer category) {
		StringBuilder sb = new StringBuilder(
				"from CmsConfigItem bean where bean.config.id=? and bean.category=?");
		sb.append(" order by bean.priority asc,bean.id asc");
		return find(sb.toString(),configId,category);
	}

	public CmsConfigItem findById(Integer id) {
		CmsConfigItem entity = get(id);
		return entity;
	}

	public CmsConfigItem save(CmsConfigItem bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsConfigItem deleteById(Integer id) {
		CmsConfigItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsConfigItem> getEntityClass() {
		return CmsConfigItem.class;
	}
}