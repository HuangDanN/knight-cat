package com.knight.cat.configuration;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.knight.cat.annotation.NoPermission;
import com.knight.cat.enums.ResultCodeEnum;
import com.knight.cat.exception.BaseException;
import com.knight.cat.util.BaseUtil;
import org.hibernate.validator.HibernateValidator;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * @author : xn-h
 * @date: 2021/10/25  10:13
 * @description: 配置信息
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class WebConfiguration implements WebMvcRegistrations, WebMvcConfigurer {

    /**
     * @return org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping
     * @author : xn-h
     * @date: 2020/10/10  16:40
     * @description: 设置requestMapping 处理
     */
    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new SuperControllerRequestMappingHandlerMapping();
    }

    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册Sa-Token的路由拦截器
        registry.addInterceptor(new SaRouteInterceptor((request, response, handler) -> {
            boolean flag = true;
            if (handler instanceof HandlerMethod) {
                NoPermission noPermission = BaseUtil.findAnnotation((HandlerMethod) handler, NoPermission.class);
                if(ObjectUtil.isNotNull(noPermission)){
                    flag = false;
                }
            }
            if(flag){
                String path = request.getRequestPath();
                if(!StpUtil.hasPermission(path)){
                    throw new BaseException(ResultCodeEnum.AUTH_FAIL);
                }
            }
        })).addPathPatterns("/**").excludePathPatterns("/no/permission/**");
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        /**设置validator模式为快速失败返回*/
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .addProperty("hibernate.validator.fail_fast", "true")
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}
