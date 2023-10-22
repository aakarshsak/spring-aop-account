package com.example.accountspringaop.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExpressions {

//    @Pointcut("execution(* writeName())")
//    public void beforeAllMethodsStartingWithAdd() {
//    }
//

//
//    @Pointcut("execution(* com.example.accountspringaop.Account.*(..))")
//    public void forAllMethodsInsideAccount() {
//    }
//
//    @Pointcut("execution(String com.example.accountspringaop.Account.get*())")
//    public void forGettersMethodsInAccount() {
//    }
//
//    @Pointcut("execution(void com.example.accountspringaop.Account.set*(*))")
//    public void forSettersMethodsInAccount() {
//    }
//

//
//    @Pointcut("forAllMethodsInsideAccount() && !(forGettersMethodsInAccount() || forSettersMethodsInAccount())")
//    public void forAllMethodsInAccountExceptGettersAndSetters(){
//    }
//
//    @Pointcut("execution(* com.example.accountspringaop.AccountDao.say*(..))")
//    public void forMethodsStartingWithSayInAccountDao() {
//    }
//
//    @Pointcut("execution(* com.example.accountspringaop.AccountDao.getAccounts())")
//    public void forGetAccountMethodInAccountDao() {
//    }
//
//    @Pointcut("execution(void com.example.accountspringaop.AccountDao.setAccounts(..))")
//    public void forSetAccountMethodInAccountDao() {
//    }
//
//    @Pointcut("execution(* com.example.accountspringaop.MembershipDao.getMemberNames())")
//    public void forGetMemberNamesOfEachAccountMethodInMembershipDao() {
//    }
//


    ///////////////////////////
    @Pointcut("execution(* addAccount(com.example.accountspringaop.Account))")
    public void forAddAccountMethods() {
    }

    @Pointcut("execution(* com.example.accountspringaop.AccountDao.*(..))")
    public void forAllMethodsInsideAccountDao() {
    }

    @Pointcut("execution(String com.example.accountspringaop.AccountDao.get*())")
    public void forGettersMethodsInAccountDao() {
    }

    @Pointcut("execution(void com.example.accountspringaop.AccountDao.set*(*))")
    public void forSettersMethodsInAccountDao() {
    }

    @Pointcut("forAllMethodsInsideAccountDao() && !(forGettersMethodsInAccountDao() || forSettersMethodsInAccountDao() || forAddAccountMethods())")
    public void forAllMethodsInAccountDaoExceptGettersAndSetters(){
    }

    @Pointcut("execution(* com.example.accountspringaop.*.print*(..))")
    public void forPrintDateTimeAndMonthMethodInGoogleAccountDao(){
    }

    @Pointcut("execution(* com.example.accountspringaop..*.*(..))")
    public void forAllMethodsInsideParentPackage() {
    }

    @Pointcut("!execution(* com.example.accountspringaop.AccountSp*.*(..)) && forAllMethodsInsideParentPackage()")
    public void forAllMethodsInsideParentPackageAndNotInMainClass() {
    }

    @Pointcut("execution(* com.example.accountspringaop.Account.print*(..))")
    public void forPrintMethodsInAccount() {
    }

    @Pointcut("execution(* com.example.accountspringaop..*.findAccounts(..))")
    public void forfindAccountsMethods() {
    }

    @Pointcut("execution(* com.example.accountspringaop.*.CryptoAccountDao.getHo*(..))")
    public void forGetMemberNamesOfEachAccountMethodInAccountDao() {
    }

    @Pointcut("execution(* tellFor*())")
    public void forTellFortuneWithDelayMethods() {
    }

    @Pointcut("execution(* tellFor*(*))")
    public void forTellFortuneMethods() {
    }
}
