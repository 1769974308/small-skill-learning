package com.taotao;

import com.taotao.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.rmi.runtime.Log;

@SpringBootApplication
public class LogbackApplication {

    static Logger logger = LoggerFactory.getLogger(LogbackApplication.class);

    private static void applicationLogger(){
        logger.trace("LogbackApplication {} log","trace");
        logger.debug("LogbackApplication {} log","debug");
        logger.info("LogbackApplication {} log","info");
        logger.warn("LogbackApplication {} log","warn");
        logger.error("LogbackApplication {} log","error");
    }


    public static void main(String[] args) {
        SpringApplication.run(LogbackApplication.class, args);
        applicationLogger();
        Utils.utilsLogger();
    }

}
