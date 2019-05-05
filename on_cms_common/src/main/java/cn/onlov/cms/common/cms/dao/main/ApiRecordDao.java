package cn.onlov.cms.common.cms.dao.main;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.cms.entity.main.ApiRecord;

public interface ApiRecordDao {
	public Pagination getPage(int pageNo, int pageSize);
	
	public ApiRecord findBySign(String sign,String appId);

	public ApiRecord findById(Long id);

	public ApiRecord save(ApiRecord bean);

	public ApiRecord updateByUpdater(Updater<ApiRecord> updater);

	public ApiRecord deleteById(Long id);
}