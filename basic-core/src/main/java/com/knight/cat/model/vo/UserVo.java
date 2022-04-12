package com.knight.cat.model.vo;

import com.knight.cat.model.dto.UserMenuDTO;

import java.util.List;

/**
 * @author : xn-h
 * @date: 2022/4/4  19:12
 * @description: 用户视图类
 */
public class UserVo {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户菜单信息
     */
    private List<UserMenuDTO> userMenus;

    public List<UserMenuDTO> getUserMenus() {
        return userMenus;
    }

    public void setUserMenus(List<UserMenuDTO> userMenus) {
        this.userMenus = userMenus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
