package com.taotao;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
public class SpringbootSentinelApplication {

    public static void main(String[] args) {


        SpringApplication.run(SpringbootSentinelApplication.class, args);
    }

    @Bean
    public SentinelResourceAspect sentinelResourceAspect(){
        return new SentinelResourceAspect();
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
