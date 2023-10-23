package com.example.accountspringaop;

import com.example.accountspringaop.crypto.CryptoAccountDao;
import com.example.accountspringaop.service.FortuneService;
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
	public CommandLineRunner commandLineRunner(AccountDao accountDao, GoogleAccountDao googleAccountDao, CryptoAccountDao cryptoAccountDao, FortuneService fortuneService) {
		System.out.println("\n\nCalling command line runner....".toUpperCase());
		return runner -> {
//			doSomeStuffToDemonstrateBeforeAdvice(accountDao, googleAccountDao, cryptoAccountDao);
//			doSomeStuffToDemonstrateAfterReturningAdvice(cryptoAccountDao);
//			doSomeStuffToDemonstrateAfterThrowingAdvice(cryptoAccountDao);
//			doSomeStuffToDemonstrateAfterAdvice(accountDao);
			doSomeStuffToDemonstrateAroundAdvice(fortuneService);
		};
	}

	private void doSomeStuffToDemonstrateAroundAdvice(FortuneService fortuneService) {
		System.out.println("############## Demonstrating @AfterReturning Advice #############");

		String fortune = null;
		try {
			fortune = fortuneService.tellFortuneWithDelay();
		} catch(Exception exception) {
			System.out.println(exception);
		}
		System.out.println("My Fortune: " + fortune);

		try {
			fortune = fortuneService.tellFortune(true);
		} catch(Exception exception) {
			fortune = null;
			System.out.println(exception);
		}


		System.out.println("My Fortune: " + fortune);

		System.out.print("Printing Years Fortune: ");
		fortuneService.printYearsFortuneWithDelay();

	}

	private void doSomeStuffToDemonstrateAfterAdvice(AccountDao accountDao) {
		System.out.println("############## Demonstrating @After Advice #############");
		accountDao.activateAccount();
	}

	private void doSomeStuffToDemonstrateAfterReturningAdvice(CryptoAccountDao cryptoAccountDao) {
		System.out.println("############## Demonstrating @AfterReturning Advice #############");

		Account account1 = new Account(124566, "Kishu Singhania", "WazirX");
		Account account2 = new Account(563394, "Saxena Mathur", "Binance");
		Account account3 = new Account(676384, "Aman Verma", "Kucoin");

		cryptoAccountDao.insertAccount(account1);
		cryptoAccountDao.insertAccount(account2);
		cryptoAccountDao.insertAccount(account3);

		System.out.println("Printing Crypto Accounts: " + cryptoAccountDao.findAccounts());
		System.out.println("Printing Holder's Names: " + cryptoAccountDao.getHoldersNames());
	}

	private void doSomeStuffToDemonstrateAfterThrowingAdvice(CryptoAccountDao cryptoAccountDao) {
		System.out.println("############## Demonstrating @AfterThrowing Advice #############");

		Account account1 = new Account(124566, "Kishu Singhania", "WazirX");
		Account account2 = new Account(563394, "Saxena Mathur", "Binance");
		Account account3 = new Account(676384, "Aman Verma", "Kucoin");

		cryptoAccountDao.insertAccount(account1);
		cryptoAccountDao.insertAccount(account2);
		cryptoAccountDao.insertAccount(account3);

		try {
			System.out.println("Printing Crypto Accounts: " + cryptoAccountDao.findAccounts(true));
		} catch(Exception ex) {
			System.out.println("Printing Exception: " + ex);
		}
	}

	private void doSomeStuffToDemonstrateBeforeAdvice(AccountDao accountDao, GoogleAccountDao googleAccountDao, CryptoAccountDao cryptoAccountDao) {
		System.out.println("############## Demonstrating @Before Advice #############");

		Account account1 = new Account(124566, "Aakarsh Sinha", "SBI");
		Account account2 = new Account(563394, "Sakshi Malik", "GCP");
		Account account3 = new Account(676384, "Aman Verma", "Kucoin");

		accountDao.addAccount(account1);
		googleAccountDao.addAccount(account2);
		cryptoAccountDao.addAccount(account3);

		accountDao.activateAccount();

		googleAccountDao.printCurrentDateTimeAndMonth(new Date(System.currentTimeMillis()), "October");

		account3.printAccountDetails();

	}


}
