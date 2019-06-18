package com.example.merchant_rating_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MerchantRatingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantRatingApiApplication.class, args);
	}

}
