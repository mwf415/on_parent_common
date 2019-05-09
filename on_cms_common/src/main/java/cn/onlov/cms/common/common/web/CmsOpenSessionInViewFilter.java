package cn.onlov.cms.common.common.web;

import org.springframework.orm.hibernate4.support.OpenSessionInViewFilter;

import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns={"*.do","*.jhtml","*.htm","*.jspx","*.jsp","/api/*","/"}, filterName="cmsOpenSessionInViewFilter")
public class CmsOpenSessionInViewFilter extends OpenSessionInViewFilter {


}
