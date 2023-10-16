package com.example.accountspringaop;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private int num;
    private String name;
    private Date expiry;

    public String printAccountDetails(String writer) {
        return num + " " + name + " " + expiry + " by:- " + writer;
    }
}
