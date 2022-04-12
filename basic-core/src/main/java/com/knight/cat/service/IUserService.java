package com.knight.cat.service;

import com.knight.cat.model.dto.UserLoginDTO;
import com.knight.cat.model.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.knight.cat.model.vo.UserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xn-h
 * @since 2022-04-04
 */
public interface IUserService extends IService<User> {

    UserVo login(UserLoginDTO userLoginDTO);
}
