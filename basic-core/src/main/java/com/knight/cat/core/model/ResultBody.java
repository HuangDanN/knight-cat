package com.knight.cat.core.model;

import cn.hutool.core.util.ObjectUtil;
import com.knight.cat.enums.ResultCodeEnum;

import java.io.Serializable;

/**
 * @author : xn-h
 * @date: 2022/4/4  19:19
 * @description: 返回结果封装类
 */
public class ResultBody<T> implements Serializable {

    private static final long serialVersionUID = 4384054448324175729L;

    /**
     * 响应码
     */
    private String ret = "00000";

    /**
     * 提示信息
     */
    private String msg;


    /**
     * 响应数据
     */
    private T data;

    /**
     * 响应时间
     */
    private long timestamp = System.currentTimeMillis();

    /**
     * 日志ID
     */
    private String logId;

    /**
     * @param data 返回数据
     * @author : xn-h
     * @date: 2020/7/7  16:55
     * @description: 成功返回信息
     */
    public static <T> ResultBody<T> success(T data) {
        return new ResultBody<T>().ret(ResultCodeEnum.SUCCESS.getCode()).msg(ResultCodeEnum.SUCCESS.getMessage()).data(data);
    }

    /**
     * @author : xn-h
     * @date: 2020/7/27  13:44
     * @description: 异常返回信息
     */
    public static  ResultBody<Boolean> error(String code, String msg) {
        return new ResultBody<Boolean>().ret(code).msg(msg).data(false);
    }

    public static  ResultBody<Boolean> error(ResultCodeEnum resultCodeEnum) {
        return new ResultBody<Boolean>().ret(resultCodeEnum.getCode()).msg(resultCodeEnum.getMessage()).data(false);
    }

    public static <T> ResultBody<T> error(String code, String msg, T data) {
        return new ResultBody<T>().ret(code).msg(msg).data(data);
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public ResultBody<T> ret(String ret) {
        this.ret = ret;
        return this;
    }

    public ResultBody<T> msg(String message) {
        this.msg = message;
        return this;
    }

    public ResultBody<T> data(T data) {
        this.data = data;
        return this;
    }

    public ResultBody<T> logId(String logId) {
        this.logId = logId;
        return this;
    }
}
