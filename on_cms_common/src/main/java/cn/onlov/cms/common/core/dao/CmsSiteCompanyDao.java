package cn.onlov.cms.common.core.dao;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.core.entity.CmsSiteCompany;

public interface CmsSiteCompanyDao {

	public CmsSiteCompany save(CmsSiteCompany bean);

	public CmsSiteCompany updateByUpdater(Updater<CmsSiteCompany> updater);
}