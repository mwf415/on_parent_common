package cn.onlov.on_cms_common.cms.dao.main;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.cms.entity.main.CmsModel;

public interface CmsModelDao {
	public List<CmsModel> getList(boolean containDisabled,Boolean hasContent,Integer siteId);

	public CmsModel getDefModel();

	public CmsModel findById(Integer id);
	
	public CmsModel findByPath(String path);

	public CmsModel save(CmsModel bean);

	public CmsModel updateByUpdater(Updater<CmsModel> updater);

	public CmsModel deleteById(Integer id);
}