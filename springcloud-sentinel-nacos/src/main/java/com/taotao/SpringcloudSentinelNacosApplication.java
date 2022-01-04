package com.taotao;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
public class SpringcloudSentinelNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudSentinelNacosApplication.class, args);
    }


    @Slf4j
    @RestController
    static class TestController{
        @GetMapping("/hello")
        @SentinelResource(value="dosomething",blockHandler = "exceptionHandler")
        public String hello(){
            log.info("request|time|{}",new Date().toString());
            return "hello sentinel";
        }
    }
}
