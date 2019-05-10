package cn.onlov.cms.common.common.web.freemarker;

import cn.onlov.cms.common.common.web.ProcessTimeFilter;
import freemarker.core.Environment;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.Map;

/**
 * 执行时间标签
 * 
 * 需要拦截器cn.onlov.cms.common.common.web.ProcessTimeFilter支持
 */
@Component("process_time")
public class ProcessTimeDirective implements TemplateDirectiveModel {
	private static final Logger log = LoggerFactory
			.getLogger(ProcessTimeDirective.class);
	private static final DecimalFormat FORMAT = new DecimalFormat("0.000");

	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		long time = getStartTime(env);
		if (time != -1) {
			time = System.currentTimeMillis() - time;
			Writer out = env.getOut();
			out.append("Processed in " + FORMAT.format(time / 1000F)
					+ " second(s)");
		}
	}

	private long getStartTime(Environment env) throws TemplateModelException {
		TemplateModel startTime = env.getGlobalVariable(ProcessTimeFilter.START_TIME);
		if (startTime == null) {
			log.warn("Variable '{}' not found in GlobalVariable", ProcessTimeFilter.START_TIME);
			return -1;
		}
		if (startTime instanceof TemplateNumberModel) {
			return ((TemplateNumberModel) startTime).getAsNumber().longValue();
		} else {
			throw new MustNumberException(ProcessTimeFilter.START_TIME);
		}
	}

}
