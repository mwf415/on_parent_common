package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.Channel;
import cn.onlov.on_cms_common.cms.entity.main.ChannelExt;

public interface ChannelExtMng {
	public ChannelExt save(ChannelExt ext, Channel channel);

	public ChannelExt update(ChannelExt ext);
}