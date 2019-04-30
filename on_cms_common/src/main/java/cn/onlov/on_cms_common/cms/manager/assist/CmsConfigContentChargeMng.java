package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.Map;

import cn.onlov.on_cms_common.cms.entity.assist.CmsConfigContentCharge;

public interface CmsConfigContentChargeMng {
	
	public CmsConfigContentCharge findById(Integer id) ;
	
	public CmsConfigContentCharge getDefault();

	public CmsConfigContentCharge update(CmsConfigContentCharge bean
			,String payTransferPassword,Map<String,String> keys,Map<String,String>fixVal);
	
	public CmsConfigContentCharge afterUserPay(Double payAmout);

}