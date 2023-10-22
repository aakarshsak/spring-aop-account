package com.example.accountspringaop.aop;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@Order(100)
public class MyApiManagementAspect {

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAddAccountMethods()")
    public void addingAddBeforeAdvice() {
        System.out.println("\n------- >> @Before advice for API Management Aspect...");
    }

    @After("execution(void ac*())")
    public void addingAfterAdvice() {
        System.out.println("\n------- >> @After advice for API Management Aspect...");
    }

}
