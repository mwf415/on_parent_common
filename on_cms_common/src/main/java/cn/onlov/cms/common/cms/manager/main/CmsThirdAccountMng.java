package cn.onlov.cms.common.cms.manager.main;

import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.main.CmsThirdAccount;

public interface CmsThirdAccountMng {
	public Pagination getPage(String username, String source, int pageNo, int pageSize);

	public CmsThirdAccount findById(Long id);
	
	public CmsThirdAccount findByKey(String key);

	public CmsThirdAccount save(CmsThirdAccount bean);

	public CmsThirdAccount update(CmsThirdAccount bean);

	public CmsThirdAccount deleteById(Long id);
	
	public CmsThirdAccount[] deleteByIds(Long[] ids);
}