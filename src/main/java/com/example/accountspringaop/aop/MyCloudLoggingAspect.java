package com.example.accountspringaop.aop;


import com.example.accountspringaop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
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


    // Even with void it will give the same response for intercepting void methods so its better to use Object for all methods
    @Around("com.example.accountspringaop.aop.PointCutExpressions.forPrintFortuneMethods()")
    public Object addingAroundAdviceWithVoid(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("\n------- >> @Around STARTED advice for Cloud Logging Aspect to check for void method...");

        long startTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("Time Taken for execution: " + (endTime - startTime)/1000.0);
        System.out.println("\n------- >> @Around ENDED advice for logging Aspect to handle exception for method...");

        return result;
    }

}
