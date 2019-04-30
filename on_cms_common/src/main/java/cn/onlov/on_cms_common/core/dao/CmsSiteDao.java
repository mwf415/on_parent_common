package cn.onlov.on_cms_common.core.dao;

import java.util.List;
import java.util.Map;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.entity.CmsSite;

/**
 * 站点DAO接口
 */
public interface CmsSiteDao {
	/**
	 * 获得站点数量
	 * 
	 * @param cacheable
	 * @return
	 */
	public int siteCount(boolean cacheable);

	/**
	 * 获得所有站点
	 * 
	 * @param cacheable
	 * @return
	 */
	public List<CmsSite> getList(boolean cacheable);
	
	public int  getCountByProperty(String property);

	public CmsSite findByDomain(String domain);
	

	public CmsSite findById(Integer id);

	public CmsSite save(CmsSite bean);

	public CmsSite updateByUpdater(Updater<CmsSite> updater);

	public CmsSite deleteById(Integer id);
	
	public List<Map<String, Object>> getAttrListBySiteId(Integer siteId);
	
	public Integer deleteAttrListBySiteId(Integer id);
}