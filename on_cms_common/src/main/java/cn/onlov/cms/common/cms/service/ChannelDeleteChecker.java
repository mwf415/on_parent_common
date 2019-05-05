package cn.onlov.cms.common.cms.service;

/**
 * 检查章节是否可以删除的接口
 */
public interface ChannelDeleteChecker {
	/**
	 * 如不能删除，则返回国际化提示信息；否则返回null。
	 */
	public String checkForChannelDelete(Integer channelId);
}