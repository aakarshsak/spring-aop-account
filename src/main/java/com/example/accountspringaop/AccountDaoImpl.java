package com.example.accountspringaop;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountDaoImpl implements AccountDao {

    List<Account> accounts;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public void addAccount(Account account) {
        System.out.println("=============> Adding Bank Accounts <================");
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
    public void activateAccount() {
        System.out.println("=============> Activating Bank Accounts <================");
    }
}
