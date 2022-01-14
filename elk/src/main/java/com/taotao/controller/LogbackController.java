package com.taotao.controller;

/**
 * @auther ASUS
 * @date 2022/1/14
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logback")
public class LogbackController {

    Logger logger = LoggerFactory.getLogger(LogbackController.class);

    @RequestMapping("/trace")
    public void trace(){
        logger.trace("trace|日志关联ID|{}","hello trace");
        logger.debug("trace|日志关联ID|{}","hello trace debug");
        logger.info("trace|日志关联ID|{}","hello trace info");
        logger.warn("trace|日志关联ID|{}","hello trace warn");
        logger.error("trace|日志关联ID|{}","hello trace error");


    }
}
