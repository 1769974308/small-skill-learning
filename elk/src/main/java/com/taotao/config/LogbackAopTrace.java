package com.taotao.config;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @auther ASUS
 * @date 2022/1/14
 */
@Aspect
@Component
public class LogbackAopTrace {
    private static String MDC_TRACE_ID = "traceId";

    @Pointcut("@annotation(com.taotao.annotion.BetaTrace)")
    public void traceMthod() {
    }

    @Before("traceMthod()")
    public void before() {
        if (MDC.get(MDC_TRACE_ID) == null) {
            MDC.put(MDC_TRACE_ID, UUID.randomUUID().toString().replace("-", ""));
        }
    }

    @AfterReturning(pointcut = "traceMthod()")
    public void afterReturning() {
        MDC.remove(MDC_TRACE_ID);
    }
}
