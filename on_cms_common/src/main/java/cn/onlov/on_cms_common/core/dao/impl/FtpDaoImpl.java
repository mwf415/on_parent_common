package cn.onlov.on_cms_common.core.dao.impl;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.core.dao.FtpDao;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.core.entity.Ftp;

@Repository
public class FtpDaoImpl extends HibernateBaseDao<Ftp, Integer> implements
        FtpDao {
	@SuppressWarnings("unchecked")
	public List<Ftp> getList() {
		String hql = "from Ftp bean";
		return find(hql);
	}

	public Ftp findById(Integer id) {
		Ftp entity = get(id);
		return entity;
	}

	public Ftp save(Ftp bean) {
		getSession().save(bean);
		return bean;
	}

	public Ftp deleteById(Integer id) {
		Ftp entity = super.get(id);
		if (entity != null) {
			getSession().delete(entity);
		}
		return entity;
	}

	@Override
	protected Class<Ftp> getEntityClass() {
		return Ftp.class;
	}
}