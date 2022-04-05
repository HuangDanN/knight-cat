package com.knight.cat.core.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : xn-h
 * @date: 2022/4/4  16:21
 * @description: 顶级父类
 */
public abstract class BaseModelParent implements BaseModel, Serializable {

    /**
     * 主键
     */
    protected Integer id;

    /**
     * 创建人
     */
    @TableField(value = "create_id", fill = FieldFill.INSERT)
    @JsonIgnore
    protected String createId;

    /**
     * 更新人
     */
    @TableField(value = "update_id", fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    protected String updateId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    protected LocalDateTime updateTime;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
