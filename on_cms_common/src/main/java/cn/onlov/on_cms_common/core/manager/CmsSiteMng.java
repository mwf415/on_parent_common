package cn.onlov.on_cms_common.core.manager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.entity.CmsUser;

public interface CmsSiteMng {
	public List<CmsSite> getList();

	public List<CmsSite> getListFromCache();

	public CmsSite findByDomain(String domain);
	
	public boolean hasRepeatByProperty(String property);

	public CmsSite findById(Integer id);

	public CmsSite save(CmsSite currSite, CmsUser currUser, CmsSite bean,
			Integer uploadFtpId,Integer syncPageFtpId) throws IOException;
	
	public CmsSite update(CmsSite site);

	public CmsSite update(CmsSite bean, Integer uploadFtpId,Integer syncPageFtpId,Integer ossId);

	public void updateTplSolution(Integer siteId, String solution,String mobileSol);
	
	public void updateAttr(Integer siteId,Map<String,String>attr);
	
	public void updateAttr(Integer siteId,Map<String,String>...attrs);
	
	public List<Map<String,Object>> getAttrListBySiteId(Integer siteId);
	
	public Integer deleteAttrListBySiteId(Integer[] args);
	
	public CmsSite deleteById(Integer id);

	public CmsSite[] deleteByIds(Integer[] ids);
}