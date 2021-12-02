package com.taotao.config;

/**
 * @auther ASUS
 * @date 2021/12/2
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 *
 */
@Configuration
@MapperScan("com.taotao.mbg.mapper")
public class MyBatisConfig {
}
