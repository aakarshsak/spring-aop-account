package com.example.accountspringaop.aop;


import com.example.accountspringaop.Account;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(100)
public class MyApiManagementAspect {

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAllAddAccountMethods()")
    public void addingAddBeforeAdvice() {
        System.out.println("\n@Before advice for API Management Aspect...");
    }

    @AfterReturning(pointcut = "com.example.accountspringaop.aop.PointCutExpressions.forGetAccountMethodInAccountDao()", returning = "result")
    public void afterReturningForGetAccounts(List<Account> result) {
        System.out.println("\n@AfterReturning advice for API Management Aspect which returns -----> " + result + "....");
    }
}
