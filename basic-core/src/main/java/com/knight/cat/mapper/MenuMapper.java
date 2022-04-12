package com.knight.cat.mapper;

import com.knight.cat.model.dto.UserMenuDTO;
import com.knight.cat.model.po.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xn-h
 * @since 2022-04-11
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<UserMenuDTO> getUserMenu(Integer userId);
}
