package com.taotao.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @auther ASUS
 * @date 2022/1/12
 */
public class Utils {


    private  static final Logger logger = LoggerFactory.getLogger(Utils.class);

    public static  void utilsLogger(){
        logger.trace("LogbackApplication {} log","trace");
        logger.debug("LogbackApplication {} log","debug");
        logger.info("LogbackApplication {} log","info");
        logger.warn("LogbackApplication {} log","warn");
        logger.error("LogbackApplication {} log","error");
    }
}
