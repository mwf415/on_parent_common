package cn.onlov.on_cms_common.core.dao;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsDictionary;

public interface CmsDictionaryDao {
	public Pagination getPage(String queryType, int pageNo, int pageSize);
	
	public List<CmsDictionary> getList(String type);
	
	public List<String> getTypeList();

	public CmsDictionary findById(Integer id);
	
	public CmsDictionary findByValue(String type,String value);

	public CmsDictionary save(CmsDictionary bean);

	public CmsDictionary updateByUpdater(Updater<CmsDictionary> updater);

	public CmsDictionary deleteById(Integer id);

	public int countByValue(String value, String type);
}