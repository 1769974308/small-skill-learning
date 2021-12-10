package com.taotao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @auther ASUS
 * @date 2021/12/10
 */
@Component
public class SpringTask {

    private Logger LOGGER = LoggerFactory.getLogger(SpringTask.class);


    /***               秒              分钟         小时         日                   月         周
     *  时间元素      seconds          minutes     hours        day                 month      week
     *  可出现的字符   ，- * /         , - * /     , - * /    , - * / ? L W        ，- * /     , - * / ? L W #
     *
     *  , : 表示列出枚举值 ,例如 分钟域使用 5，10 ，表示在5分钟和10分钟各触发一次
     *
     *  - ：表示触发范围，例如 分钟域使用5-10，表示从5分钟到10分钟每分钟触发一次
     *
     *  * ：表示匹配任意值，例如 分钟域使用 * ，表示每分钟都会触发一次
     *
     *  / : 表示起始时间开始触发，每隔固定时间触发一次，例如 分钟域使用 5/10，表示5分钟时触发一次，每10分钟再触发一次
     *
     *  ？ ：只能在日和星期（周）中指定使用，用于匹配任意值 ，例如 日域使用？，表示每天都触发一次
     *
     *  # ： 只能在周中指定使用，第几个星期几，
     *
     *  L : 表示最后
     *
     *  W ：表示有效工作日
     *
     *
     */



    @Scheduled(cron = "0/10 * * ? * ?")
    private void  cancelTimeOutOrder(){
        LOGGER.info("取消过期订单");
    }
}
