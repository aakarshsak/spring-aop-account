package com.example.accountspringaop;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private long num;
    private String name;
    private String bank;

    public void printAccountDetails() {
        System.out.println("=============> Printing account Details from Account Class <================");
        System.out.println(this.toString());
    }
}
