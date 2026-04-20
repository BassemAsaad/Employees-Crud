package com.bassem.employees.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger log = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.employees.crud.controller.*.*(..))")
    public void controllerPackage() {}

    @Pointcut("execution(* com.employees.crud.service.*.*(..))")
    public void servicePackage() {}

    @Pointcut("execution(* com.employees.crud.repos.*.*(..))")
    public void repositoryPackage() {}

    @Pointcut("controllerPackage() || servicePackage() || repositoryPackage()")
    public void appFlow() {}

    @Before("appFlow()")
    public void before(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        log.info("============>>> Executing @Before method: " + method);

        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.info("============>>> Argument: " + arg);
        }
        log.info("\n");
    }

    @AfterReturning(pointcut = "appFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toShortString();
        log.info("============>>> Executing @AfterReturning method: " + method);

        log.info("=============>>> Returning argument: " + result);
        log.info("\n");

    }
}
