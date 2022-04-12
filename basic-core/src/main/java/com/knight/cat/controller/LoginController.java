package com.knight.cat.controller;

import com.knight.cat.model.dto.UserLoginDTO;
import com.knight.cat.model.vo.UserVo;
import com.knight.cat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : xn-h
 * @date: 2022/4/11  16:09
 * @description: 登录接口
 */
@RestController
@RequestMapping
public class LoginController extends NoPermissionController{

    @Autowired
    private IUserService userService;

    @PostMapping(value = "login")
    public UserVo login(@Valid @RequestBody UserLoginDTO userLoginDTO){
        return userService.login(userLoginDTO);
    }
}
