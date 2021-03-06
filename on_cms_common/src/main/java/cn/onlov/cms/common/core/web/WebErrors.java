package cn.onlov.cms.common.core.web;

import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Locale;

public class WebErrors extends WebCoreErrors {

	/**
	 * 通过HttpServletRequest创建WebErrors
	 * 
	 * @param request
	 *            从request中获得MessageSource和Locale，如果存在的话。
	 * @return 如果LocaleResolver存在则返回国际化WebErrors
	 */
	public static WebErrors create(HttpServletRequest request) {
		return new WebErrors(request);
	}

	public WebErrors() {
	}

	public WebErrors(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 构造器
	 * 
	 * @param messageSource
	 * @param locale
	 */
	public WebErrors(MessageSource messageSource, Locale locale) {
		super(messageSource, locale);
	}

	/**
	 * 非站点内数据
	 * 
	 * @param clazz
	 * @param id
	 */
	public void notInSite(Class<?> clazz, Serializable id) {
		addErrorCode("error.notInSite", clazz.getSimpleName(), id);
	}
}
