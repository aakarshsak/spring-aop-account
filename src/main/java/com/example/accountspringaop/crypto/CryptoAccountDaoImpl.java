package com.example.accountspringaop.crypto;

import com.example.accountspringaop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CryptoAccountDaoImpl implements CryptoAccountDao {
    List<Account> accounts;

    @Override
    public void addAccount(Account account) {
        System.out.println("=============> Adding Crypto Accounts <================");
        if(accounts==null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }

    @Override
    public void insertAccount(Account account) {
        System.out.println("=============> Inserting Crypto Account <================");
        if(accounts==null) {
            accounts = new ArrayList<>();
        }
        accounts.add(account);
    }

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean isThrowing) {

        System.out.print("=============> Finding Crypto Accounts <================");
        if(isThrowing) {
            throw new RuntimeException("Hey!!! Something in wrong. I am not getting the list of accounts.");
        }

        return accounts;
    }

    @Override
    public List<String> getHoldersNames() {
        return findAccounts().stream().map(Account::getName).collect(Collectors.toList());
    }
}
