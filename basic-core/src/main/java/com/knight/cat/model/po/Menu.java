package com.knight.cat.model.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.knight.cat.core.model.BaseModelParent;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author xn-h
 * @since 2022-04-11
 */
@TableName("t_menu")
public class Menu extends BaseModelParent {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单请求地址
     */
    private String menuUrl;

    /**
     * 菜单编码
     */
    private String menuCode;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
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

    @Override
    public String toString() {
        return "Menu{" +
            "menuName=" + menuName +
            ", menuUrl=" + menuUrl +
            ", menuCode=" + menuCode +
        "}";
    }

    @Override
    public String getName() {
        return this.menuName;
    }
}
