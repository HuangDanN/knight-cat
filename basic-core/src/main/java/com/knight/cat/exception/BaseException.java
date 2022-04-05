package com.knight.cat.exception;

import com.knight.cat.enums.ResultCodeEnum;

/**
 * @author : xn-h
 * @date: 2022/4/4  22:35
 * @description: 异常信息
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = -8254568201344430275L;

    private ResultCodeEnum resultCode;

    private Object data;

    public BaseException(ResultCodeEnum resultCode){
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public BaseException(ResultCodeEnum resultCode, Object data){
        super(resultCode.getMessage());
        this.resultCode = resultCode;
        this.data = data;
    }

    public BaseException(Object data){
        super(ResultCodeEnum.ERROR.getMessage());
        this.resultCode = ResultCodeEnum.ERROR;
        this.data = data;
    }


    public ResultCodeEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
