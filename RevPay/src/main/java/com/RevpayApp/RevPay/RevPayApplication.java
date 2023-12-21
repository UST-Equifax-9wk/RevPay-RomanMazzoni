package com.RevpayApp.RevPay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.RevpayApp.RevPay.controllers",
		"com.RevpayApp.RevPay.services",
		"com.RevpayApp.RevPay.repositories"})
public class RevPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevPayApplication.class, args);
	}

}
