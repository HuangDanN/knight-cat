package com.knight.cat.model.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author : xn-h
 * @date: 2022/4/11  16:19
 * @description: 用户登录信息
 */
public class UserLoginDTO {

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
