package com.example.accountspringaop.crypto;

import com.example.accountspringaop.Account;

import java.util.List;

public interface CryptoAccountDao {

    void addAccount(Account account);

    void insertAccount(Account account);
    List<Account> findAccounts();
    List<Account> findAccounts(boolean isThrowing);
    List<String> getHoldersNames();
}
