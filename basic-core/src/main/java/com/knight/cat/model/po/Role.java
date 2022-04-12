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
@TableName("t_role")
public class Role extends BaseModelParent {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" +
            "roleName=" + roleName +
        "}";
    }

    @Override
    public String getName() {
        return this.roleName;
    }
}
