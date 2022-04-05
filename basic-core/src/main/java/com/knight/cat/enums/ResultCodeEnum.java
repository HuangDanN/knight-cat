package com.knight.cat.enums;

/**
 * @author : xn-h
 * @date: 2022/4/4  21:36
 * @description: 编码枚举
 */
public enum ResultCodeEnum {

    // 成功返回信息
    SUCCESS("000000", "success"),
    ERROR("999999", "系统异常"),
    PAGE_404("100001", "请求地址不存在"),
    NOT_LOGIN("100002", "未登录,没有权限访问"),
    AUTH_FAIL("100003", "认证失败,没有权限访问"),
    VALID_ERROR("100004", "参数校验失败"),
    LOGIN_FAIL("100005", "用户名或密码失败"),
    LIMIT_LOGIN("100006", "登录失败次数太多,登录已被限制,请一小时后再试"),
    REQUEST_METHOD_NOT_SUPPORTED("100007", "请求方法不支持"),
    REQUIRED_REQUEST_BODY_IS_MISSING("100008","Required request body 缺失"),
    CONTENT_TYPE_NOT_SUPPORTED("100009","Content type 不支持"),
    ;

    private String code;
    private String message;

    ResultCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
