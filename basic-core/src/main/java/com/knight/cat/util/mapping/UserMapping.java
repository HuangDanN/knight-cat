package com.knight.cat.util.mapping;

import com.knight.cat.model.po.User;
import com.knight.cat.model.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/**
 * @author : xn-h
 * @date: 2022/4/4  19:10
 * @description: 用户映射类
 */
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapping {

    UserVo poToVo(User user);
}
