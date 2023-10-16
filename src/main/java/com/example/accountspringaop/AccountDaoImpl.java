package com.example.accountspringaop;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao {

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
