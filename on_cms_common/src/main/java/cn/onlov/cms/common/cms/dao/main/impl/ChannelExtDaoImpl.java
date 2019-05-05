package cn.onlov.cms.common.cms.dao.main.impl;

import cn.onlov.cms.common.cms.dao.main.ChannelExtDao;
import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import org.springframework.stereotype.Repository;

import cn.onlov.cms.common.cms.entity.main.ChannelExt;

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