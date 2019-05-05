package cn.onlov.cms.common.cms.task.job;

import cn.onlov.cms.common.cms.api.Constants;
import cn.onlov.cms.common.common.util.DateUtils;
import cn.onlov.cms.common.core.manager.CmsSiteMng;
import cn.onlov.cms.common.core.manager.CmsUserExtMng;
import cn.onlov.cms.common.cms.manager.main.ApiUserLoginMng;
import cn.onlov.cms.common.core.entity.CmsSite;
import net.sf.ehcache.Ehcache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

/**
 * @Description 每日任务(执行每日pv、每日访客量清空)
 * @author tom
 */
public class SiteDayJob{
	private static final Logger log = LoggerFactory.getLogger(SiteDayJob.class);
	
	public void execute() {
		clearDayPvAndVisitor();
		clearApiUserLogin();
		clearDayCount();
	}
	
	private void clearDayPvAndVisitor(){
		List<CmsSite>sites=cmsSiteMng.getList();
		Map<String,String>dayPv=new HashMap<String, String>();
		dayPv.put(CmsSite.DAY_PV_TOTAL, "0");
		Map<String,String>dayVisitor=new HashMap<String, String>();
		dayVisitor.put(CmsSite.DAY_VISITORS, "0");
		for(CmsSite site:sites){
			cmsSiteMng.updateAttr(site.getId(), dayPv,dayVisitor);
		}
		dayPvTotalCache.removeAll();
		dayVisitorTotalCache.removeAll();
		log.info("Clear Day Pv And Visitor Job success!");
	}
	
	//清除API用户(超时登陆信息)
	private void clearApiUserLogin(){
		Date end= DateUtils.getMinuteBeforeTime(Calendar.getInstance().getTime(),
				Constants.USER_OVER_TIME);
		apiUserLoginMng.clearByDate(end);
	}
	//清零用户当日评论数、当日留言数
	private void clearDayCount(){
		userExtMng.clearDayCount();
	}
	
	@Autowired
	private CmsSiteMng cmsSiteMng;
	@Autowired
	private ApiUserLoginMng apiUserLoginMng;
	@Autowired
	private CmsUserExtMng userExtMng;
	
	@Autowired 
	@Qualifier("cmsDayPvTotalCache")
	private Ehcache dayPvTotalCache;
	@Autowired 
	@Qualifier("cmsDayVisitorTotalCache")
	private Ehcache dayVisitorTotalCache;
}
