package cn.onlov.on_cms_common.plug.weixin.dao.impl;

import java.util.List;

import cn.onlov.on_cms_common.plug.weixin.dao.WeixinDao;
import cn.onlov.on_cms_common.plug.weixin.entity.Weixin;
import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.common.page.Pagination;

public class WeixinDaoImpl extends HibernateBaseDao<Weixin, Integer> implements WeixinDao {
	
	public Pagination getPage(Integer siteId,int pageNo,int pageSize){
		Finder f = Finder.create(" from Weixin bean where 1=1");
		f.append(" and bean.site.id=:siteId");
		f.setParam("siteId", siteId);
		return find(f,pageNo,pageSize);
	}
	
	public Weixin findById(Integer id){
		return get(id);
	}
	
	public Weixin find(Integer siteId){
		Finder f = Finder.create(" from Weixin bean where 1=1");
		f.append(" and bean.site.id=:siteId").setParam("siteId", siteId);
		List<Weixin> list = find(f);
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public Weixin deleteById(Integer id){
		Weixin entity = get(id);
		if(entity!=null){
			getSession().delete(entity);
			return entity;
		}
		return null;
	}
	
	public Weixin save(Weixin bean){
		getSession().save(bean);
		return bean;
	}

	@Override
	protected Class<Weixin> getEntityClass() {
		return Weixin.class;
	}

}
