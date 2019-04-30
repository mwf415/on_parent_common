package cn.onlov.on_cms_common.core.dao;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.entity.CmsGroup;

public interface CmsGroupDao {
	public List<CmsGroup> getList();

	public CmsGroup getRegDef();

	public CmsGroup findById(Integer id);
	
	public CmsGroup findByName(String name);

	public CmsGroup save(CmsGroup bean);

	public CmsGroup updateByUpdater(Updater<CmsGroup> updater);

	public CmsGroup deleteById(Integer id);
}