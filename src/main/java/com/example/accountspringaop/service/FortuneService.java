package com.example.accountspringaop.service;

public interface FortuneService {
    String tellFortune(boolean isThrowing);

    String tellFortuneWithDelay() throws InterruptedException;
    void printYearsFortuneWithDelay();
}
