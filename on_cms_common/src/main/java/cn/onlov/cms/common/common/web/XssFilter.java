package cn.onlov.cms.common.common.web;

/**
 * @author Tom
 */
import cn.onlov.cms.common.core.web.util.URLHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns={"*.jhtml","*.html","*.jspx","*.jsp"}, filterName="xssFilter")
@Component
public class XssFilter implements Filter {
	private String excludeUrls ="/member@/flow_statistic@/api/content/save@/api/content/update@/api/template/save@/api/template/update@/api/resource/save@/api/resource/update@/api/keyword/save@/api/keyword/update";
	FilterConfig filterConfig = null;
	public void init(FilterConfig filterConfig) throws ServletException {
		this.excludeUrls=excludeUrls;
	}

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		if(isExcludeUrl(request)){
			chain.doFilter(request, response);
		}else{
			HttpServletRequest req=(HttpServletRequest)request;
			chain.doFilter(new XssHttpServletRequestWrapper(req), response);
		}
	}
	
	private boolean isExcludeUrl(ServletRequest request){
		boolean exclude=false;
		if(StringUtils.isNotBlank(excludeUrls)){
			 String[]excludeUrl=excludeUrls.split("@");
			 if(excludeUrl!=null&&excludeUrl.length>0){
				 for(String url:excludeUrl){
					 if(URLHelper.getURI((HttpServletRequest)request).startsWith(url)){
						 exclude=true;
					 }
				 }
			 }
		}
		return exclude;
	}

}
