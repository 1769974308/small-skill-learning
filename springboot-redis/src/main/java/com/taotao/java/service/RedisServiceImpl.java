package com.taotao.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @auther ASUS
 * @date 2021/12/9
 */
@Service
public class RedisServiceImpl implements RedisService {



    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}
