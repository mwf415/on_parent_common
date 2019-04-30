package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.ApiRecord;
import cn.onlov.on_cms_common.common.page.Pagination;

public interface ApiRecordMng {
	public Pagination getPage(int pageNo, int pageSize);

	public ApiRecord findById(Long id);
	
	public ApiRecord findBySign(String sign,String appId);
	
	public ApiRecord callApiRecord(String ip,String appId,String apiUrl,String sign);

	public ApiRecord save(ApiRecord bean);

	public ApiRecord update(ApiRecord bean);

	public ApiRecord deleteById(Long id);
	
	public ApiRecord[] deleteByIds(Long[] ids);
}