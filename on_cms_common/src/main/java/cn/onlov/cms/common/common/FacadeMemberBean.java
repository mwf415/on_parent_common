package cn.onlov.cms.common.common;

import cn.onlov.cms.common.common.web.springmvc.BindingInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Component
public class FacadeMemberBean {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(10);
        messageSource.setBasenames("/WEB-INF/languages/jeecms/adminapi/messages");
        return messageSource;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
        return commonsMultipartResolver;

    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter (){
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = new RequestMappingHandlerAdapter();
        requestMappingHandlerAdapter.setWebBindingInitializer(new BindingInitializer());
        return requestMappingHandlerAdapter;
    }



}
