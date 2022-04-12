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
@TableName("t_user_role")
public class UserRole {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    private Integer userId;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole{" +
            "userId=" + userId +
            ", roleId=" + roleId +
        "}";
    }
}
