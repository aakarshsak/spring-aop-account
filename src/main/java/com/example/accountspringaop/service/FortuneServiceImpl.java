package com.example.accountspringaop.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class FortuneServiceImpl implements FortuneService{
    @Override
    public String tellFortune(boolean isThrowing) {

        if(isThrowing) {
            throw new RuntimeException("Bullocks!!! I cant see your fortune...");
        }

        return "Wowzaaaa! You are going to have a great day at office...";
    }

    @Override
    public String tellFortuneWithDelay() throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);

        return "Holy Shit!!! I am seeing a rich man in like 2 months....";
    }
}
