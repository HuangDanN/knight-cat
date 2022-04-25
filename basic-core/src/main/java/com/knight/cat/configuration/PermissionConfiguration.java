package com.knight.cat.configuration;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.knight.cat.constant.RedisKeyConstant;
import com.knight.cat.model.dto.UserMenuDTO;
import com.knight.cat.service.IMenuService;
import com.knight.cat.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xn-h
 * @date: 2022/4/12  14:07
 * @description: stp接口实现业务层
 */
@Component
public class PermissionConfiguration implements StpInterface {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        String key = RedisKeyConstant.USER_PERMISSION + loginId.toString();
        Object object = redisUtil.get(key);
        if(ObjectUtil.isNotNull(object)){
            return (List<String>) object;
        }
        List<UserMenuDTO> userMenuDTOList = menuService.getUserMenu(Integer.parseInt(loginId.toString()));
        if(CollUtil.isNotEmpty(userMenuDTOList)){
            List<String> permissionList = new ArrayList<>();
            for(UserMenuDTO userMenuDTO : userMenuDTOList){
                permissionList.add(userMenuDTO.getMenuUrl());
            }
            redisUtil.set(key, permissionList, RedisKeyConstant.ONE_DAY_EXPIRATION_TIME);
            return permissionList;
        }
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
