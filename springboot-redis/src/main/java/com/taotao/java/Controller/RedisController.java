package com.taotao.java.Controller;

import com.taotao.java.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther ASUS
 * @date 2021/12/9
 */
@Controller
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private  String REDIS_KEY_PREFIX_AUTH_CODE;

    @RequestMapping("/set/{value}")
    @ResponseBody
    public String redisSetValue(@PathVariable("value") String value){
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE,value);
        return redisService.get(REDIS_KEY_PREFIX_AUTH_CODE);
    }
}
