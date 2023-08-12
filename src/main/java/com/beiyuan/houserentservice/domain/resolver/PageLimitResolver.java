package com.beiyuan.houserentservice.domain.resolver;

import com.beiyuan.houserentservice.infrastructure.common.PageLimiter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: beiyuan
 * 拦截控制器中分页插件
 */
@Component
public class PageLimitResolver implements HandlerMethodArgumentResolver {

    private static final PageLimiter defaultPageLimiter = new PageLimiter(1, 5);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return PageLimiter.class == parameter.getParameterType();
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        if(request==null){
            return defaultPageLimiter;
        }
        //获取请求中cookie
        String page = request.getParameter("page");
        String size = request.getParameter("size");
        if (!StringUtils.isBlank(page) && !StringUtils.isBlank(size)) {
            try {
                return new PageLimiter(Integer.parseInt(page),Integer.parseInt(size));
            }catch (Exception e){
                return defaultPageLimiter;
            }
        }
        return defaultPageLimiter;
    }
}
