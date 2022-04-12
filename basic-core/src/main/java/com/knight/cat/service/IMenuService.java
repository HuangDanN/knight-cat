package com.knight.cat.service;

import com.knight.cat.model.dto.UserMenuDTO;
import com.knight.cat.model.po.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xn-h
 * @since 2022-04-11
 */
public interface IMenuService extends IService<Menu> {

    List<UserMenuDTO> getUserMenu(Integer userId);
}
