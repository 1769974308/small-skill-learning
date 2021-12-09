package com.taotao.java.service;

/**
 * @auther ASUS
 * @date 2021/12/9
 */
public interface RedisService {


    void set(String key ,String value);

    String get(String key);
}
