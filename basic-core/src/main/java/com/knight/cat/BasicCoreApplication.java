package com.knight.cat;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : xn-h
 * @date: 2022/4/4  10:05
 * @description: 启动类
 */
@SpringBootApplication
@MapperScan("com.knight.cat.**.mapper")
public class BasicCoreApplication {

    private static final Log log = LogFactory.get();

    public static void main(String[] args) {
        SpringApplication.run(BasicCoreApplication.class, args);
        log.info("基础核心启动成功....");
    }
}
