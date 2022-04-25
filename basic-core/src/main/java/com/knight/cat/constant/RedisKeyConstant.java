package com.knight.cat.constant;

/**
 * @author : xn-h
 * @date: 2022/4/12  22:09
 * @description: 缓存常量
 */
public class RedisKeyConstant {

    public final static String USER_PERMISSION = "USER:PERMISSION:";

    /**
     * redis 默认过期时间 1分钟
     */
    public final static Long DEFAULT_EXPIRATION_TIME = 60L;

    public final static Long ONE_DAY_EXPIRATION_TIME = 60L * 60L * 24L;
}
