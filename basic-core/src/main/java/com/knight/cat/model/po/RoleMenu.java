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
@TableName("t_role_menu")
public class RoleMenu {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    private Integer roleId;

    private Integer menuId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
            "roleId=" + roleId +
            ", menuId=" + menuId +
        "}";
    }
}
