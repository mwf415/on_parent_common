package cn.onlov.cms.common.cms.dao.main.impl;

import java.util.List;

import cn.onlov.cms.common.cms.dao.main.CmsModelItemDao;
import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.cms.common.cms.entity.main.CmsModelItem;

@Repository
public class CmsModelItemDaoImpl extends
        HibernateBaseDao<CmsModelItem, Integer> implements CmsModelItemDao {
	@SuppressWarnings("unchecked")
	public List<CmsModelItem> getList(Integer modelId, boolean isChannel,
			Boolean hasDisabled) {
		StringBuilder sb = new StringBuilder(
				"from CmsModelItem bean where bean.model.id=? and bean.channel=?");
		if (hasDisabled!=null) {
			if(!hasDisabled){
				sb.append(" and bean.display=true");
			}else{
				sb.append(" and bean.display=false");
			}
		}
		sb.append(" order by bean.priority asc,bean.id asc");
		return find(sb.toString(), modelId, isChannel);
	}

	public CmsModelItem findById(Integer id) {
		CmsModelItem entity = get(id);
		return entity;
	}

	public CmsModelItem save(CmsModelItem bean) {
		getSession().save(bean);
		return bean;
	}

	public CmsModelItem deleteById(Integer id) {
		CmsModelItem entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<CmsModelItem> getEntityClass() {
		return CmsModelItem.class;
	}
}