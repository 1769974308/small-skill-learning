package com.taotao.controller;


import cn.hutool.json.JSONUtil;
import com.taotao.damain.ResResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ASUS
 * @date 2022/6/17
 */
@RestController
@RequestMapping("/rest")
@Slf4j
public class RestTemplateController {

    @Autowired
    private RestTemplate restTemplate;

    private final static String URL = "http://localhost:8080/data/";

    @RequestMapping("/info")
    private String restTemplateInfo(){


        ResResult forObjectList = restTemplate.getForObject(URL + "/list?reqId=1", ResResult.class);

        log.info("forObjectList:[{}]", JSONUtil.toJsonStr(forObjectList));
        return "";
    }
}
