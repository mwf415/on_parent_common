package cn.onlov.cms.common.common.web.freemarker;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/**
 * UUID生成器
 */
@Component("uuid")
public class UUIDDirective implements TemplateDirectiveModel {
	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String uuid = UUID.randomUUID().toString();
		uuid = StringUtils.remove(uuid, '-');
		env.getOut().append(uuid);
	}
}
