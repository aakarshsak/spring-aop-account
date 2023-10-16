package com.example.accountspringaop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAllAddAccountMethods()")
    public void addingAddBeforeAdvice() {
        System.out.println("\n@Before advice for logging Aspect...");
    }


    //This will not load as its not possible to create proxy for POJO
    @Before("com.example.accountspringaop.aop.PointCutExpressions.forPrintMethodsInAccount()")
    public void addingBeforeToShowAopWontWorkWithPOJO() {
        System.out.println("\n@Before advice for logging Aspect with method Signature...");
    }

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forMethodsStartingWithSayInAccountDao()")
    public void addingBeforeToGetMethodSignature(JoinPoint joinPoint) {

        System.out.println("\n@Before advice for logging Aspect with method Signature...");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println(methodSignature);
    }
}
