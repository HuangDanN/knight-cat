package com.knight.cat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.knight.cat.mapper.MenuMapper;
import com.knight.cat.model.dto.UserMenuDTO;
import com.knight.cat.model.po.Menu;
import com.knight.cat.service.IMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xn-h
 * @since 2022-04-11
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {


    @Override
    public List<UserMenuDTO> getUserMenu(Integer userId) {
        return this.baseMapper.getUserMenu(userId);
    }
}
