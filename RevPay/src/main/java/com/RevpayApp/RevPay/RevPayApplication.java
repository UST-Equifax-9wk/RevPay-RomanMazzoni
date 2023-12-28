package com.RevpayApp.RevPay;

import com.RevpayApp.RevPay.controllers.UserController;
import com.RevpayApp.RevPay.entities.Account;
import com.RevpayApp.RevPay.entities.UserAccount;
import com.RevpayApp.RevPay.services.AccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
		"com.RevpayApp.RevPay.controllers",
		"com.RevpayApp.RevPay.services",
		"com.RevpayApp.RevPay.repositories"})
public class RevPayApplication {

	public static void main(String[] args) {
		ApplicationContext iocContainer = SpringApplication.run(RevPayApplication.class, args);

		//UserController userController = iocContainer.getBean(UserController.class);
		/*
		AccountService accountService = iocContainer.getBean(AccountService.class);
		UserAccount userAccount = new UserAccount();
		Account account = new Account();



		accountService.createNewAccount(account);

		 */


	}

}
