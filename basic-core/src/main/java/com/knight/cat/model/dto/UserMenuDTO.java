package com.knight.cat.model.dto;

/**
 * @author : xn-h
 * @date: 2022/4/11  16:11
 * @description: 用户权限信息
 */
public class UserMenuDTO {

    /**
     * 菜单请求地址
     */
    private String menuUrl;

    /**
     * 菜单编码
     */
    private String menuCode;

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }
}
