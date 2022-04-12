package com.knight.cat.util;

import org.springframework.web.method.HandlerMethod;

import java.lang.annotation.Annotation;

/**
 * @author : xn-h
 * @date: 2022/4/12  14:24
 * @description: 工具类
 */
public class BaseUtil {

    public static <T extends Annotation> T findAnnotation(HandlerMethod handler, Class<T> annotationType) {
        T annotation = handler.getBeanType().getAnnotation(annotationType);
        if (annotation != null) {
            return annotation;
        }
        return handler.getMethodAnnotation(annotationType);
    }
}
