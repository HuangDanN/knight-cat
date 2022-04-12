package com.knight.cat.service.impl;

import com.knight.cat.model.po.Role;
import com.knight.cat.mapper.RoleMapper;
import com.knight.cat.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xn-h
 * @since 2022-04-11
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
