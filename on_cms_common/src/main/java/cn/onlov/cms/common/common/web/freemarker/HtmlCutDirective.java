package cn.onlov.cms.common.common.web.freemarker;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import cn.onlov.cms.common.common.util.StrUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * HTML文本提取并截断
 * 
 * 需要拦截器cn.onlov.on_cms_common.common.web.ProcessTimeFilter支持
 */
public class HtmlCutDirective implements TemplateDirectiveModel {
	public static final String PARAM_S = "s";
	public static final String PARAM_LEN = "len";
	public static final String PARAM_APPEND = "append";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		String s = DirectiveUtils.getString(PARAM_S, params);
		Integer len = DirectiveUtils.getInt(PARAM_LEN, params);
		String append = DirectiveUtils.getString(PARAM_APPEND, params);
		if (s != null) {
			Writer out = env.getOut();
			if (len != null) {
				out.append(StrUtils.htmlCut(s, len, append));
			} else {
				out.append(s);
			}
		}
	}
}
