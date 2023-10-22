package com.example.accountspringaop.aop;


import com.example.accountspringaop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(6)
public class MyCloudLoggingAspect {

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAddAccountMethods()")
    public void addingAddBeforeAdvice() {
        System.out.println("\n------- >> @Before advice for Cloud Logging Aspect...");
    }

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forPrintDateTimeAndMonthMethodInGoogleAccountDao()")
    public void addingBeforeToGetMethodParameters(JoinPoint joinPoint) {
        System.out.println("\n------- >> @Before advice for Cloud logging Aspect with all of method Arguments...");
        Object[] args = joinPoint.getArgs();
        for(Object arg: args) {
            System.out.println("\"" + arg + "\" of type ("+ arg.getClass().getName() +")");
        }
    }

    @AfterThrowing(pointcut = "com.example.accountspringaop.aop.PointCutExpressions.forfindAccountsMethods()", throwing = "throwable")
    public void addingBeforeToGetMethodSignature(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("\n------- >> @AfterThrowing advice for Cloud Logging Aspect to handle exceptions");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature: " + methodSignature);
        System.out.println("Exception: " + throwable);
    }

}
