package cn.onlov.on_cms_common.cms.manager.main.impl;

import cn.onlov.on_cms_common.cms.dao.main.ContentExtDao;
import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.entity.main.ContentExt;
import cn.onlov.on_cms_common.cms.manager.main.ContentExtMng;
import cn.onlov.on_cms_common.common.hibernate4.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContentExtMngImpl implements ContentExtMng {
	public ContentExt save(ContentExt ext, Content content) {
		content.setContentExt(ext);
		ext.setContent(content);
		if (ext.getReleaseDate() == null) {
			ext.setReleaseDate(content.getSortDate());
		}
		ext.init();
		dao.save(ext);
		content.setContentExt(ext);
		return ext;
	}

	public ContentExt update(ContentExt bean) {
		Updater<ContentExt> updater = new Updater<ContentExt>(bean);
		if (bean.getPigeonholeDate()==null) {
			updater.include("pigeonholeDate");
		}
		if(bean.getTopLevelDate()==null){
			updater.include("topLevelDate");
		}
		bean = dao.updateByUpdater(updater);
		bean.blankToNull();
		// 修改后需要重新生成静态页
		bean.setNeedRegenerate(true);
		return bean;
	}

	private ContentExtDao dao;

	@Autowired
	public void setDao(ContentExtDao dao) {
		this.dao = dao;
	}
}