package com.knight.cat.controller;

import com.knight.cat.model.vo.UserVo;
import com.knight.cat.service.IUserService;
import com.knight.cat.util.mapping.UserMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xn-h
 * @since 2022-04-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapping userMapping;

    @GetMapping(value = "/{id}")
    public UserVo getInfo(@PathVariable(value = "id") Integer id){
        return userMapping.poToVo(userService.getById(id));
    }
}
