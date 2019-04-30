package cn.onlov.on_cms_common.core.manager;

import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.entity.CmsSiteCompany;

public interface CmsSiteCompanyMng {
	public CmsSiteCompany save(CmsSite site,CmsSiteCompany bean);

	public CmsSiteCompany update(CmsSiteCompany bean);
}