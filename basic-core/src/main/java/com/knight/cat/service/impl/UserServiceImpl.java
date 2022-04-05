package com.knight.cat.service.impl;

import com.knight.cat.model.po.User;
import com.knight.cat.mapper.UserMapper;
import com.knight.cat.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
