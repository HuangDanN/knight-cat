package com.knight.cat.configuration;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.knight.cat.annotation.NotResultBody;
import com.knight.cat.core.model.ResultBody;
import com.knight.cat.enums.ResultCodeEnum;
import com.knight.cat.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.beans.PropertyEditorSupport;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @author : xn-h
 * @date: 2022/4/4  21:24
 * @description: 控制层异常及返回值处理
 */
@RestController
@ControllerAdvice
public class ControllerAdviceConfig implements ResponseBodyAdvice<Object> {

    private static final Log log = LogFactory.get();

    @Autowired
    private HttpServletRequest request;

    /**
     * 解密前端GET方法传递的参数
     *
     * @author xn-h
     * @date 2022/4/4  22:40
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        String methodType = request.getMethod();
        if (ServletUtil.METHOD_GET.equals(methodType)) {
            binder.registerCustomEditor(String.class, new PropertyEditorSupport() {
                @Override
                public void setAsText(String text) {
                    text = URLDecoder.decode(text, StandardCharsets.UTF_8);
                    setValue(URLDecoder.decode(text, StandardCharsets.UTF_8));
                }
            });
        }
    }

    /**
     * 判断是否需要返回结果封装类
     *
     * @author xn-h
     * @date 2022/4/4  22:41
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        boolean flag = returnType.hasMethodAnnotation(NotResultBody.class);
        return !flag;
    }

    /**
     * 将返回结果封装起来
     *
     * @author xn-h
     * @date 2022/4/4  22:41
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof ResultBody) {
            return body;
        }
        return ResultBody.success(body);
    }

    @ExceptionHandler(value = {RuntimeException.class, Exception.class})
    public ResultBody<Boolean> handleRuntimeException(Exception exception) {
        log.error(exception);
        return ResultBody.error(ResultCodeEnum.ERROR);
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ResultBody<Boolean> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error("请求方法不支持 ----> {}", exception.getMessage());
        return ResultBody.error(ResultCodeEnum.REQUEST_METHOD_NOT_SUPPORTED);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResultBody<Boolean> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        log.error("缺少请求参数 ----> {}", exception.getMessage());
        return ResultBody.error(ResultCodeEnum.REQUIRED_REQUEST_BODY_IS_MISSING);
    }

    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    public ResultBody<Boolean> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException exception) {
        log.error("请求 Content type 不支持 ----> {}", exception.getMessage());
        return ResultBody.error(ResultCodeEnum.CONTENT_TYPE_NOT_SUPPORTED);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultBody<Boolean> notFountHandler() {
        return ResultBody.error(ResultCodeEnum.PAGE_404);
    }


    @ExceptionHandler(value = {BaseException.class})
    public ResultBody handleBaseException(BaseException baseException) {
        log.error("异常信息--->{}.{}", baseException.getResultCode().getCode(), baseException.getResultCode().getMessage());
        return ResultBody.error(baseException.getResultCode().getCode(), baseException.getResultCode().getMessage(), baseException.getData());
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResultBody handleAssertException(IllegalArgumentException baseException) {
        log.error("异常信息--->{}", baseException.getMessage());
        return ResultBody.error(ResultCodeEnum.ERROR.getCode(), baseException.getMessage(), baseException.getMessage());
    }

    /**
     * @author : xn-h
     * @date: 2020/9/3  17:21
     * @description: 参数校验异常捕获处理
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class, ConstraintViolationException.class})
    public ResultBody handleValidException(Exception e) {
        //Hibernate Validator验证消息返回
        BindingResult result = null;
        if (e instanceof MethodArgumentNotValidException) {
            result = ((MethodArgumentNotValidException) e).getBindingResult();
        } else if (e instanceof BindException) {
            result = ((BindException) e).getBindingResult();
        } else if (e instanceof ConstraintViolationException) {
            Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) e).getConstraintViolations();
            StringBuilder errorMsg = new StringBuilder();
            for (ConstraintViolation<?> violation : constraintViolations) {
                errorMsg.append(violation.getMessage()).append(",");
            }
            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            log.error("参数验证失败 ---> {}", errorMsg);
            return ResultBody.error(ResultCodeEnum.VALID_ERROR.getCode(), errorMsg.toString());
        }
        if (result != null) {
            StringBuilder errorMsg = new StringBuilder();
            for (ObjectError error : result.getAllErrors()) {
                errorMsg.append(error.getDefaultMessage()).append(",");
            }
            errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
            log.error("参数验证失败 ---> {} ", errorMsg);
            return ResultBody.error(ResultCodeEnum.VALID_ERROR.getCode(), errorMsg.toString());
        }
        log.error("参数验证失败 -->  {}", e.getMessage());
        log.error(e);
        return ResultBody.error(ResultCodeEnum.VALID_ERROR.getCode(), ResultCodeEnum.VALID_ERROR.getMessage());
    }
}
