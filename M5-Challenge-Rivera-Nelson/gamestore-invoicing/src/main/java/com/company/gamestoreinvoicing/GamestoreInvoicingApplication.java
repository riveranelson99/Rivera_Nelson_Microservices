package com.company.gamestoreinvoicing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GamestoreInvoicingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamestoreInvoicingApplication.class, args);
	}

}
