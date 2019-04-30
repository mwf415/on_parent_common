package cn.onlov.on_cms_common.cms.dao.main.impl;

import cn.onlov.on_cms_common.cms.dao.main.ChannelExtDao;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.main.ChannelExt;

@Repository
public class ChannelExtDaoImpl extends HibernateBaseDao<ChannelExt, Integer>
		implements ChannelExtDao {
	public ChannelExt save(ChannelExt bean) {
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<ChannelExt> getEntityClass() {
		return ChannelExt.class;
	}
}