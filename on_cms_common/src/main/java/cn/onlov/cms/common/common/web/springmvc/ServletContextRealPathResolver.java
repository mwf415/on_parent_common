package cn.onlov.cms.common.common.web.springmvc;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component("realPathResolver")
public class ServletContextRealPathResolver implements RealPathResolver,
		ServletContextAware {
	public String get(String path) {
		String realpath=context.getRealPath(path);
		//tomcat8.0获取不到真实路径，通过/获取路径
		if(StringUtils.isBlank(realpath)){
			realpath=context.getRealPath("/")+path;
		}
		return realpath;
	}

	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
	}

	private ServletContext context;
}
