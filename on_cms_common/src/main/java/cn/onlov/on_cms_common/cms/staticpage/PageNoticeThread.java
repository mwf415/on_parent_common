package cn.onlov.on_cms_common.cms.staticpage;

import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.service.ContentListener;
import cn.onlov.on_cms_common.cms.web.ApplicationContextUtil;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.List;

public class PageNoticeThread extends Thread {

	private Content content;
	private List<ContentListener> listenerList;

	public PageNoticeThread(Content content,
			List<ContentListener> listenerList) {
		super();
		this.content=content;
		this.listenerList=listenerList;
	}
	

	@Override
	public void run() {
			HibernateTransactionManager transactionManager = (HibernateTransactionManager) ApplicationContextUtil.getBean("transactionManager");
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW); // 事物隔离级别，开启新事务
			TransactionStatus status = transactionManager.getTransaction(def); // 获得事务状态
			try {
				//逻辑代码
				if (listenerList != null) {
					for (ContentListener listener : listenerList) {
						listener.afterSave(content);
					}
				}
				transactionManager.commit(status);
			} catch (Exception e) {
				transactionManager.rollback(status);
			}
	}
}
