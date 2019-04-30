package cn.onlov.on_cms_common.core.manager;

import java.util.List;
import java.util.Set;

import cn.onlov.on_cms_common.core.entity.CmsRole;

public interface CmsRoleMng {
	
	public List<CmsRole> getList(Integer level);

	public CmsRole findById(Integer id);

	public CmsRole save(CmsRole bean, Set<String> perms);

	public CmsRole update(CmsRole bean, Set<String> perms);

	public CmsRole deleteById(Integer id);

	public CmsRole[] deleteByIds(Integer[] ids);

	public void deleteMembers(CmsRole role, Integer[] userIds);
}