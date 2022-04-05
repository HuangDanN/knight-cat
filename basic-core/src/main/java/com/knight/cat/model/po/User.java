package com.knight.cat.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.knight.cat.core.model.BaseModelParent;

/**
 * <p>
 * 
 * </p>
 *
 * @author xn-h
 * @since 2022-04-04
 */
@TableName("t_user")
public class User extends BaseModelParent {

    private static final long serialVersionUID = 1L;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String userName;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
            "loginName=" + loginName +
            ", password=" + password +
            ", userName=" + userName +
        "}";
    }

    @Override
    public String getName() {
        return userName;
    }
}
