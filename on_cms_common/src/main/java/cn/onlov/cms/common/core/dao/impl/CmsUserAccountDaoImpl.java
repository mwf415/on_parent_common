package cn.onlov.cms.common.core.dao.impl;

import java.util.Date;

import cn.onlov.cms.common.common.hibernate4.Finder;
import cn.onlov.cms.common.common.hibernate4.HibernateBaseDao;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.common.util.DateUtils;
import cn.onlov.cms.common.core.entity.CmsUserAccount;
import cn.onlov.cms.common.core.dao.CmsUserAccountDao;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

@Repository
public class CmsUserAccountDaoImpl extends HibernateBaseDao<CmsUserAccount, Integer> implements CmsUserAccountDao {
	
	public Pagination getPage(String username, Date drawTimeBegin, Date drawTimeEnd,
                              int orderBy, int pageNo, int pageSize){
		String hql=" select bean from CmsUserAccount bean where 1=1 ";
		Finder f=Finder.create(hql);
		if(StringUtils.isNotBlank(username)){
			f.append(" and bean.user.username=:username").setParam("username", username);
		}
		if(drawTimeBegin!=null){
			f.append(" and bean.lastDrawTime>=:drawTimeBegin")
			.setParam("drawTimeBegin", DateUtils.getStartDate(drawTimeBegin));
		}
		if(drawTimeEnd!=null){
			f.append(" and bean.lastDrawTime<=:drawTimeEnd")
			.setParam("drawTimeEnd", DateUtils.getFinallyDate(drawTimeEnd));
		}
		if(orderBy==1){
			f.append(" order by bean.contentTotalAmount desc ");
		}else if(orderBy==2){
			f.append(" order by bean.contentTotalAmount asc ");
		}else if(orderBy==3){
			f.append(" order by bean.contentYearAmount desc ");
		}else if(orderBy==4){
			f.append(" order by bean.contentYearAmount asc ");
		}else if(orderBy==5){
			f.append(" order by bean.contentMonthAmount desc ");
		}else if(orderBy==6){
			f.append(" order by bean.contentMonthAmount asc ");
		}else if(orderBy==7){
			f.append(" order by bean.contentDayAmount desc ");
		}else if(orderBy==8){
			f.append(" order by bean.contentDayAmount asc ");
		}else if(orderBy==9){
			f.append(" order by bean.contentBuyCount desc ");
		}else if(orderBy==10){
			f.append(" order by bean.contentBuyCount asc ");
		}else if(orderBy==11){
			f.append(" order by bean.contentNoPayAmount desc ");
		}else if(orderBy==12){
			f.append(" order by bean.contentNoPayAmount asc ");
		}
		f.setCacheable(true);
		return find(f, pageNo, pageSize);
	}
	
	public CmsUserAccount findById(Integer id) {
		CmsUserAccount entity = get(id);
		return entity;
	}

	public CmsUserAccount save(CmsUserAccount bean) {
		getSession().save(bean);
		return bean;
	}
	
	@Override
	protected Class<CmsUserAccount> getEntityClass() {
		return CmsUserAccount.class;
	}
}