package cn.onlov.on_cms_common.cms.dao.main;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.main.ChannelTxt;

public interface ChannelTxtDao {
	public ChannelTxt findById(Integer id);

	public ChannelTxt save(ChannelTxt bean);

	public ChannelTxt updateByUpdater(Updater<ChannelTxt> updater);
}