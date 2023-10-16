package com.example.accountspringaop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(6)
public class MyCloudLoggingAspect {

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAllAddAccountMethods()")
    public void addingAddBeforeAdvice() {
        System.out.println("\n@Before advice for Cloud Logging Aspect...");
    }


    @Before("com.example.accountspringaop.aop.PointCutExpressions.forMethodsStartingWithSayInAccountDao()")
    public void addingBeforeToGetMethodParameters(JoinPoint joinPoint) {

        System.out.println("\n@Before advice for Cloud logging Aspect with all of method Arguments...");
        Object[] args = joinPoint.getArgs();
        for(Object arg: args) {
            System.out.print("\"" + arg + "\" of type ("+ arg.getClass().getName() +")-->");
        }

    }

}
