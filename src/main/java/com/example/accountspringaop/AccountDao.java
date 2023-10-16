package com.example.accountspringaop;

import java.util.List;

public interface AccountDao {

    void addAccount();
    String writeName();
    void saySomething(String something, int times);
    void setAccounts(List<Account> accounts);
    List<Account> getAccounts();
}
