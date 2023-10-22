package com.example.accountspringaop.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingAspect {

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAddAccountMethods()")
    public void addingBeforeAdvice() {
        System.out.println("\n------- >> @Before advice for logging Aspect...");
    }

    @Before("com.example.accountspringaop.aop.PointCutExpressions.forAllMethodsInAccountDaoExceptGettersAndSetters()")
    public void addingBeforeAdviceLogForAllMethodsInAccountDaoExceptGettersAndSetters(JoinPoint joinPoint) {
        System.out.println("\n------- >> @Before advice for logging Aspect...");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Adding logs for method : " + methodSignature);
    }


    //This will not load as its not possible to create proxy for POJO
    @Before("com.example.accountspringaop.aop.PointCutExpressions.forPrintMethodsInAccount()")
    public void addingBeforeToShowAopWontWorkWithPOJO() {
        System.out.println("\n------- >> @Before advice for logging Aspect with method Signature...");
    }

    @Around("com.example.accountspringaop.aop.PointCutExpressions.forTellFortuneWithDelayMethods()")
    public Object addingAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("\n------- >> @Around STARTED advice for logging Aspect to get the runtime for method...");
        long startTime = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("Runtime for the block of code: " + (endTime - startTime)/1000.0);
        System.out.println("\n------- >> @Around ENDED advice for logging Aspect to get the runtime for method...");

        return result;
    }


    // We can either return with an exception or handle it and return response
    @Around("com.example.accountspringaop.aop.PointCutExpressions.forTellFortuneMethods()")
    public Object addingAroundAdviceToHandleException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("\n------- >> @Around STARTED advice for logging Aspect to handle exception for method...");

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch(Exception exception) {
            System.out.println("Handling exception: " + exception);

            // Handling exception and returning with proper response...
            // result = "No Worries!!! Everything will be alright...";


            // Throwing the exception to calling method....
            throw exception;
        }

        System.out.println("\n------- >> @Around ENDED advice for logging Aspect to handle exception for method...");

        return result;
    }
}
