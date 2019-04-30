package cn.onlov.on_cms_common.cms.dao.assist;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;

import java.util.Date;

import cn.onlov.on_cms_common.cms.entity.assist.CmsAccountPay;

public interface CmsAccountPayDao {
	public Pagination getPage(String drawNum, Integer payUserId, Integer drawUserId,
                              Date payTimeBegin, Date payTimeEnd, int pageNo, int pageSize);

	public CmsAccountPay findById(Long id);

	public CmsAccountPay save(CmsAccountPay bean);

	public CmsAccountPay updateByUpdater(Updater<CmsAccountPay> updater);

	public CmsAccountPay deleteById(Long id);
}