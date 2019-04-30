package cn.onlov.on_cms_common.core.manager;

import java.util.Date;
import java.util.Map;

import cn.onlov.on_cms_common.core.entity.CmsConfig;
import cn.onlov.on_cms_common.core.entity.CmsConfigAttr;
import cn.onlov.on_cms_common.core.entity.MarkConfig;
import cn.onlov.on_cms_common.core.entity.MemberConfig;

public interface CmsConfigMng {
	public CmsConfig get();
	
	public Integer getContentFreshMinute();

	public void updateCountCopyTime(Date d);

	public void updateCountClearTime(Date d);
	
	public void updateFlowClearTime(Date d);
	
	public void updateChannelCountClearTime(Date d);

	public CmsConfig update(CmsConfig bean);

	public MarkConfig updateMarkConfig(MarkConfig mark);

	public void updateMemberConfig(MemberConfig memberConfig);
	
	public void updateConfigAttr(CmsConfigAttr configAttr);
	
	public void updateSsoAttr(Map<String,String> ssoAttr);
	
	public void updateRewardFixAttr(Map<String,String> fixAttr);
}