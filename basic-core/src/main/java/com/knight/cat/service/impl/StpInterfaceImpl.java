package com.knight.cat.service.impl;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.collection.CollUtil;
import com.knight.cat.model.dto.UserMenuDTO;
import com.knight.cat.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : xn-h
 * @date: 2022/4/12  14:07
 * @description: stp接口实现业务层
 */
@Service
public class StpInterfaceImpl implements StpInterface {

    @Autowired
    private IMenuService menuService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        List<UserMenuDTO> userMenuDTOList = menuService.getUserMenu(Integer.parseInt(loginId.toString()));
        if(CollUtil.isNotEmpty(userMenuDTOList)){
            List<String> permissionList = new ArrayList<>();
            for(UserMenuDTO userMenuDTO : userMenuDTOList){
                permissionList.add(userMenuDTO.getMenuUrl());
            }
            return permissionList;
        }
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        return null;
    }
}
