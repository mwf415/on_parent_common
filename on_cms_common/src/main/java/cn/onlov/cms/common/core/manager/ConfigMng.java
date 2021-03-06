package cn.onlov.cms.common.core.manager;

import java.util.Map;

import cn.onlov.cms.common.common.email.EmailSender;
import cn.onlov.cms.common.common.email.MessageTemplate;
import cn.onlov.cms.common.core.entity.Config;
import cn.onlov.cms.common.core.entity.Config.ConfigLogin;

public interface ConfigMng {
	public Map<String, String> getMap();

	public ConfigLogin getConfigLogin();

	public EmailSender getEmailSender();

	public MessageTemplate getForgotPasswordMessageTemplate();
	
	public MessageTemplate getRegisterMessageTemplate();

	public String getValue(String id);

	public void updateOrSave(Map<String, String> map);

	public Config updateOrSave(String key, String value);

	public Config deleteById(String id);

	public Config[] deleteByIds(String[] ids);
}