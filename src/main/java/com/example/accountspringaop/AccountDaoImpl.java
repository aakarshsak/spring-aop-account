package com.example.accountspringaop;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    private List<Account> accounts;

    public AccountDaoImpl(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public List<Account> getAccounts() {
        System.out.println("Inside GetAccount method of AcccountDao....");
        return accounts;
    }

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB work of adding account here....");
    }

    @Override
    public String writeName() {
        return getClass() + ": Wrting my name -> Aakarsh";
    }

    @Override
    public void saySomething(String something, int times) {
        System.out.println("\nI am saying \"" + something + "\" to you...I can say it " + times + " many times...");
    }

}
