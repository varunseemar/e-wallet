package com.demo.e_wallet.beans;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* org.VarunSeemar.Varun's digital-library.*.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        log.info("Logging: Calling {} with arguments: {}",
                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
    }
}
