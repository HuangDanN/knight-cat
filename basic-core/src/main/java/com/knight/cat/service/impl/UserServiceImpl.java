package com.knight.cat.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.knight.cat.enums.ResultCodeEnum;
import com.knight.cat.exception.BaseException;
import com.knight.cat.model.dto.UserLoginDTO;
import com.knight.cat.model.po.User;
import com.knight.cat.mapper.UserMapper;
import com.knight.cat.model.vo.UserVo;
import com.knight.cat.service.IMenuService;
import com.knight.cat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knight.cat.util.mapping.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xn-h
 * @since 2022-04-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapping userMapping;

    @Autowired
    private IMenuService menuService;

    @Override
    public UserVo login(UserLoginDTO userLoginDTO) {
        User user = super.getOne(Wrappers.<User>lambdaQuery().eq(User::getLoginName, userLoginDTO.getUserName()));
        Assert.notNull(user, ResultCodeEnum.LOGIN_FAIL.getMessage());
        if(!user.getPassword().equals(userLoginDTO.getPassword())){
            throw new BaseException(ResultCodeEnum.LOGIN_FAIL);
        }
        UserVo userVo = userMapping.poToVo(user);
        userVo.setUserMenus(menuService.getUserMenu(user.getId()));
        StpUtil.login(user.getId());
        return userVo;
    }
}
