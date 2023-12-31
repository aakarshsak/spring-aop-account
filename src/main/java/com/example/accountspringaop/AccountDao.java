package com.example.accountspringaop;

import java.util.List;

public interface AccountDao {

    void addAccount(Account account);
    List<Account> findAccounts();
    void activateAccount();
}
