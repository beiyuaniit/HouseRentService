package com.beiyuan.houserentservice.domain.resolver;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: beiyuan
 */
@Configuration
public class HandlerMethodArgumentResolverAutoConfiguration implements InitializingBean {

    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodArgumentResolver> argumentResolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> customArgumentResolvers = new ArrayList<>();
        // 放在第一个
        customArgumentResolvers.add(0,new PageLimitResolver());
        for (HandlerMethodArgumentResolver argumentResolver : argumentResolvers) {
            customArgumentResolvers.add(argumentResolver);
        }
        requestMappingHandlerAdapter.setArgumentResolvers(customArgumentResolvers);
    }
}