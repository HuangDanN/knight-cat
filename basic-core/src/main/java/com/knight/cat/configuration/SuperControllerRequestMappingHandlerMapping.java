package com.knight.cat.configuration;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @author : xn-h
 * @date: 2020/10/10  16:36
 * @description: 父类requestMapping 处理
 */
public class SuperControllerRequestMappingHandlerMapping extends RequestMappingHandlerMapping {

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        Class<?> superClass = handlerType.getSuperclass();
        mappingInfo = appendParentRequestMapping(superClass, mappingInfo);
        return mappingInfo;
    }

    /**
     * @return org.springframework.web.servlet.mvc.method.RequestMappingInfo
     * @author : xn-h
     * @date: 2020/10/10  16:38
     * @description: 将父类requestMapping 添加到子类前缀
     */
    protected RequestMappingInfo appendParentRequestMapping(Class<?> handlerType, RequestMappingInfo mappingInfo) {
        if (handlerType == null) {
            return mappingInfo;
        }
        RequestMapping parentRequestMapping = handlerType.getAnnotation(RequestMapping.class);
        if (parentRequestMapping != null && parentRequestMapping.value().length > 0) {
            //使用path工具向前追加夫类的path
            RequestMappingInfo.Builder mappingBuilder = mappingInfo.mutate();
            mappingBuilder.paths(parentRequestMapping.value());
            RequestMappingInfo parentMapping = mappingBuilder.build();
            mappingInfo = parentMapping.combine(mappingInfo);
        }
        return appendParentRequestMapping(handlerType.getSuperclass(), mappingInfo);
    }

}
