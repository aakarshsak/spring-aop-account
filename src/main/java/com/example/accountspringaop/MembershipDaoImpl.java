package com.example.accountspringaop;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao{

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing db working of adding member account...");
    }
}
