package com.example.accountspringaop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class AccountSpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountSpringAopApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDao accountDao, MembershipDao membershipDao) {
		System.out.println("\n\nCalling command line runner....");
		return runner -> {
			System.out.println("\n\nStarting all methods....");

			//Account account = Account.builder().num(123).name("Aakarsh").expiry(new Date(System.currentTimeMillis())).build();

			Account account1 = new Account(123, "Aakarsh", new Date(System.currentTimeMillis()));
			Account account2 = new Account(123, "Aakarsh", new Date(System.currentTimeMillis()));
			Account account3 = new Account(123, "Aakarsh", new Date(System.currentTimeMillis()));

			List<Account> accountList = new ArrayList<>();
			accountList.add(account1);
			accountList.add(account2);
			accountList.add(account3);

			accountDao.setAccounts(accountList);
			accountDao.getAccounts();

			//These will not load as its not possible to create proxy for POJO
//			System.out.println(account1.printAccountDetails("Ramcharan"));
//			System.out.println(account2.printAccountDetails("Ramcharan"));
//			System.out.println(account3.printAccountDetails("Ramcharan"));

			accountDao.saySomething("Hello", 50000);
			accountDao.addAccount();
			membershipDao.addAccount();
//			paymentDao.addPayment();
//			System.out.println(accountDao.writeName());
		};
	}
}
