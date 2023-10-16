package com.example.accountspringaop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
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

//			Account account = new Account(123, "Aakarsh", new Date(System.currentTimeMillis()));
//			System.out.println(account.printAccountDetails("Ramcharan"));

			accountDao.saySomething("Hello", 50000);
			accountDao.addAccount();
			membershipDao.addAccount();
//			paymentDao.addPayment();
//			System.out.println(accountDao.writeName());
		};
	}
}
