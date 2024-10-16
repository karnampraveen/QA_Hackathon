package com.sahara.usersmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableFeignClients
public class UsersmanagementsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersmanagementsystemApplication.class, args);
	}

}
