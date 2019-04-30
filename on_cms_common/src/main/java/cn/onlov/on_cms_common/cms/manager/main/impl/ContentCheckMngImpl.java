package cn.onlov.on_cms_common.cms.manager.main.impl;

import cn.onlov.on_cms_common.cms.dao.main.ContentCheckDao;
import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.entity.main.ContentCheck;
import cn.onlov.on_cms_common.cms.manager.main.ContentCheckMng;
import cn.onlov.on_cms_common.common.hibernate4.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContentCheckMngImpl implements ContentCheckMng {
	public ContentCheck save(ContentCheck check, Content content) {
		check.setContent(content);
		check.init();
		dao.save(check);
		content.setContentCheck(check);
		return check;
	}

	public ContentCheck update(ContentCheck bean) {
		Updater<ContentCheck> updater = new Updater<ContentCheck>(bean);
		bean = dao.updateByUpdater(updater);
		return bean;
	}

	private ContentCheckDao dao;

	@Autowired
	public void setDao(ContentCheckDao dao) {
		this.dao = dao;
	}
}