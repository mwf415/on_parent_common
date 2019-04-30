package cn.onlov.on_cms_common.cms.web;

import cn.onlov.on_cms_common.common.web.session.SessionProvider;
import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.web.util.CmsUtils;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;


@Slf4j
public class TokenInterceptor  extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, 
    		HttpServletResponse response,Object handler) throws Exception {
    	CmsSite site=CmsUtils.getSite(request);
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            Token annotation = method.getAnnotation(Token.class);
            if (annotation != null) {
                boolean needSaveSession = annotation.save();
                if (needSaveSession) {
                	String token=UUID.randomUUID().toString();
                	request.setAttribute("token", token);
                    sessionProvider.setAttribute(request, response, "token", token);
                }
                boolean needRemoveSession = annotation.remove();
                if (needRemoveSession) {
                    if (isRepeatSubmit(request)) {
                         log.warn("please don't repeat submit,url:"+ request.getServletPath());
                         response.sendRedirect(site.getUrl());
                         return false;
                    }
                    request.setAttribute("token", null);
                    sessionProvider.setAttribute(request, response, "token", null);
                }
            }
            return true;
        } else {
            return super.preHandle(request, response, handler);
        }
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken =(String) sessionProvider.getAttribute(request, "token");
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token");
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
    
    @Autowired
    private SessionProvider sessionProvider;
}
