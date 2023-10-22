package com.example.accountspringaop.aop;

import com.example.accountspringaop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@Order(-12)
public class ProcessingAspect {
    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAllMethodsInsideParentPackageAndNotInMainClass()")
    public void addingAddBeforeAdviceForAllMethodsInProjectExceptInMainClass() {
        System.out.println("\n------- >> @Before advice for Processing Aspect...");
    }


    @AfterReturning(pointcut = "com.example.accountspringaop.aop.PointCutExpressions.forfindAccountsMethods()", returning = "result")
    public void addingBeforeToGetMethodSignature(JoinPoint joinPoint, List<Account> result) {
        System.out.println("\n------- >> @AfterReturning advice for Processing Aspect to alter all accounts list");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("Method Signature: " + methodSignature);
        System.out.println("Result: " + result);
    }

    @AfterReturning(pointcut = "com.example.accountspringaop.aop.PointCutExpressions.forGetMemberNamesOfEachAccountMethodInAccountDao()", returning = "result")
    public void afterReturningForGettingMemberNamesAndConvertingItToUpperCaseAccounts(List<String> result) {
        System.out.println("\n------- >> @AfterReturning Advice for Processing Aspect which converts to uppercase and returns Google Account Holders names....");

        result = result.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("Converting it to uppercase -> " + result);
    }
}
