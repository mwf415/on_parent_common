package cn.onlov.cms.common.core.manager;

import java.util.List;

import cn.onlov.cms.common.core.entity.CmsGroup;

public interface CmsGroupMng {
	public List<CmsGroup> getList();

	public CmsGroup getRegDef();

	public CmsGroup findById(Integer id);
	
	public CmsGroup findByName(String name);

	public void updateRegDef(Integer regDefId);

	public CmsGroup save(CmsGroup bean);
	
	public CmsGroup save(CmsGroup bean,Integer[] viewChannelIds, Integer[] contriChannelIds);

	public CmsGroup update(CmsGroup bean);
	
	public CmsGroup update(CmsGroup bean,Integer[] viewChannelIds, Integer[] contriChannelIds);

	public CmsGroup deleteById(Integer id);

	public CmsGroup[] deleteByIds(Integer[] ids);

	public CmsGroup[] updatePriority(Integer[] ids, Integer[] priority);
}