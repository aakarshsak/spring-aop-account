package com.example.accountspringaop.payment;

import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoImpl implements PaymentDao{
    @Override
    public void addPayment() {
        System.out.println(getClass() + ": Doing db work of adding a new payment");
    }
}
