package cn.onlov.on_cms_common.cms.dao.assist.impl;

import java.util.Date;
import java.util.List;

import cn.onlov.on_cms_common.cms.dao.assist.CmsSiteAccessPagesDao;
import cn.onlov.on_cms_common.common.hibernate4.Finder;
import cn.onlov.on_cms_common.common.hibernate4.HibernateBaseDao;
import cn.onlov.on_cms_common.common.page.Pagination;
import org.springframework.stereotype.Repository;

import cn.onlov.on_cms_common.cms.entity.assist.CmsSiteAccessPages;

/**
 * @author Tom
 */
@Repository
public class CmsSiteAccessPagesDaoImpl extends
        HibernateBaseDao<CmsSiteAccessPages, Integer> implements
        CmsSiteAccessPagesDao {

	@SuppressWarnings("unchecked")
	public CmsSiteAccessPages findAccessPage(String sessionId, Integer pageIndex) {
		Finder f = Finder.create("from CmsSiteAccessPages bean where bean.sessionId=:sessionId and bean.pageIndex=:pageIndex")
				.setParam("sessionId", sessionId).setParam("pageIndex",
						pageIndex);
		List<CmsSiteAccessPages> pages = find(f);
		if (pages != null && pages.size() > 0) {
			return pages.get(0);
		} else {
			return null;
		}
	}
	
	public Pagination findPages(Integer siteId, Integer orderBy, Integer pageNo, Integer pageSize){
		Finder f = Finder.create("select bean.accessPage,count(bean.accessPage),count(distinct bean.sessionId),sum(bean.visitSecond)/count(bean.accessPage) " +
				"from CmsSiteAccessPages bean where bean.site.id=:siteId").setParam("siteId", siteId);
		f.append(" group by bean.accessPage ");
		String totalHql="select count(distinct bean.accessPage) from CmsSiteAccessPages bean where bean.site.id=:siteId";
		if(orderBy!=null){
			if(orderBy==2){
				//访客数降序
				f.append(" order by count(distinct bean.sessionId) desc");
			}else if(orderBy==3){
				//每次停留时间降序
				f.append(" order by sum(bean.visitSecond)/count(bean.accessPage) desc");
			}else{
				//pv降序
				f.append(" order by count(bean.accessPage) desc");
			}
		}else{
			f.append(" order by count(bean.accessPage) desc");
		}
		return find(f,totalHql,pageNo,pageSize);
	}

	public void clearByDate(Date date) {
		//只保留当天数据
		String hql="delete from CmsSiteAccessPages bean where bean.accessDate!=:date";
		getSession().createQuery(hql).setParameter("date",date).executeUpdate();
	}

	public CmsSiteAccessPages save(CmsSiteAccessPages bean) {
		getSession().save(bean);
		return bean;
	}


	protected Class<CmsSiteAccessPages> getEntityClass() {
		return CmsSiteAccessPages.class;
	}

}
