package cn.onlov.cms.common.common;

import cn.onlov.cms.common.common.web.springmvc.BindingInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Component
public class FacadeAdminBean {

    @Bean
    public ReloadableResourceBundleMessageSource messageSource(){

        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setCacheSeconds(0);
        messageSource.setBasenames("/WEB-INF/languages/jeecms/adminapi/messages");
        return messageSource;
    }

    @Bean
    public CommonsMultipartResolver  multipartResolver(){
        return new CommonsMultipartResolver();
    }

    @Bean
    public RequestMappingHandlerAdapter requestMappingHandlerAdapter(){
        RequestMappingHandlerAdapter adapter= new RequestMappingHandlerAdapter();
        adapter.setWebBindingInitializer(new BindingInitializer());
        return adapter;

    }

    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping(){
        RequestMappingHandlerMapping mapping = new RequestMappingHandlerMapping();


        mapping.setInterceptors();
        return mapping;
    }





}
