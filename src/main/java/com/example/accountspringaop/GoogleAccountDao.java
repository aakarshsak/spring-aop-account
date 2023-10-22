package com.example.accountspringaop;

import java.util.Date;
import java.util.List;

public interface GoogleAccountDao {
    void addAccount(Account account);
    List<Account> findAccounts();
    void printCurrentDateTimeAndMonth(Date dateTime, String month);
}
