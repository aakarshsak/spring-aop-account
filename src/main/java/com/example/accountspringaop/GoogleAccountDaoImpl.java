package com.example.accountspringaop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class GoogleAccountDaoImpl implements GoogleAccountDao{

    List<Account> accounts;

    @Override
    public void addAccount(Account account) {
        System.out.println("=============> Adding Google Accounts <================");
        if(accounts==null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }

    @Override
    public List<Account> findAccounts() {
        System.out.println("=============> Finding Bank Accounts <================");
        return accounts;
    }

    @Override
    public void printCurrentDateTimeAndMonth(Date dateTime, String month) {
        System.out.println("=============> Print Current DateTime and Month for Bank Accounts <================");
        System.out.println("DateTime: " + dateTime + "\nMonth: " + month);
    }
}
