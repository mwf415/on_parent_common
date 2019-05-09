package cn.onlov.cms.common.common.web;

import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.annotation.WebFilter;


@WebFilter(urlPatterns="/*", filterName="cmsDelegatingFilterProxy")
public class CmsDelegatingFilterProxy extends DelegatingFilterProxy {
}
