package cn.onlov.on_cms_common.cms.web;

import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.web.util.CmsUtils;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 前台本地化信息拦截器
 */
public class FrontLocaleInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 本地化字符串在ModelMap中的名称
	 */
	public static final String LOCALE = "locale";

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws ServletException {
		LocaleResolver localeResolver = RequestContextUtils
				.getLocaleResolver(request);
		if (localeResolver == null) {
			throw new IllegalStateException(
					"No LocaleResolver found: not in a DispatcherServlet request?");
		}
		CmsSite site = CmsUtils.getSite(request);
		String newLocale = site.getLocaleFront();
		LocaleEditor localeEditor = new LocaleEditor();
		localeEditor.setAsText(newLocale);
		localeResolver.setLocale(request, response, (Locale) localeEditor
				.getValue());
		// Proceed in any case.
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LocaleResolver localeResolver = RequestContextUtils
				.getLocaleResolver(request);
		if (localeResolver == null) {
			throw new IllegalStateException(
					"No LocaleResolver found: not in a DispatcherServlet request?");
		}
		if (modelAndView != null) {
			modelAndView.getModelMap().addAttribute(LOCALE,
					localeResolver.resolveLocale(request).toString());
		}
	}
	
}