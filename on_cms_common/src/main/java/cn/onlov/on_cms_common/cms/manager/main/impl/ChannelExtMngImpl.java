package cn.onlov.on_cms_common.cms.manager.main.impl;

import cn.onlov.on_cms_common.cms.dao.main.ChannelExtDao;
import cn.onlov.on_cms_common.cms.entity.main.Channel;
import cn.onlov.on_cms_common.cms.entity.main.ChannelExt;
import cn.onlov.on_cms_common.cms.manager.main.ChannelExtMng;
import cn.onlov.on_cms_common.common.hibernate4.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChannelExtMngImpl implements ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel) {
		channel.setChannelExt(ext);
		ext.setChannel(channel);
		ext.init();
		dao.save(ext);
		return ext;
	}

	public ChannelExt update(ChannelExt ext) {
		Updater<ChannelExt> updater = new Updater<ChannelExt>(ext);
		updater.include(ChannelExt.PROP_FINAL_STEP);
		updater.include(ChannelExt.PROP_AFTER_CHECK);
		ChannelExt entity = dao.updateByUpdater(updater);
		entity.blankToNull();
		return entity;
	}

	private ChannelExtDao dao;

	@Autowired
	public void setDao(ChannelExtDao dao) {
		this.dao = dao;
	}
}