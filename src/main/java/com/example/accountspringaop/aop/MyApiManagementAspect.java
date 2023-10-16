package com.example.accountspringaop.aop;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(100)
public class MyApiManagementAspect {

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAllAddAccountMethods()")
    public void addingAddBeforeAdvice() {
        System.out.println("\n@Before advice for API Management Aspect...");
    }
}
