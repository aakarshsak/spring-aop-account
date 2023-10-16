package com.example.accountspringaop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExpressions {

    @Pointcut("execution(* add*(..))")
    public void forAllAddAccountMethods() {
    }

    @Pointcut("execution(* writeName())")
    public void beforeAllMethodsStartingWithAdd() {
    }

    @Pointcut("execution(* com.example.accountspringaop..*.*(..))")
    public void forAllMethodsInsideParentPackage() {
    }

    @Pointcut("execution(* com.example.accountspringaop.Account.*(..))")
    public void forAllMethodsInsideAccount() {
    }

    @Pointcut("execution(String com.example.accountspringaop.Account.get*())")
    public void forGettersMethodsInAccount() {
    }

    @Pointcut("execution(void com.example.accountspringaop.Account.set*(*))")
    public void forSettersMethodsInAccount() {
    }

    @Pointcut("execution(* com.example.accountspringaop.Account.print*(..))")
    public void forPrintMethodsInAccount() {
    }

    @Pointcut("forAllMethodsInsideAccount() && !(forGettersMethodsInAccount() || forSettersMethodsInAccount())")
    public void forAllMethodsInAccountExceptGettersAndSetters(){
    }

    @Pointcut("execution(* com.example.accountspringaop.AccountDao.say*(..))")
    public void forMethodsStartingWithSayInAccountDao() {
    }

    @Pointcut("execution(* com.example.accountspringaop.AccountDao.getAccounts(..))")
    public void forGetAccountMethodInAccountDao() {
    }

}
