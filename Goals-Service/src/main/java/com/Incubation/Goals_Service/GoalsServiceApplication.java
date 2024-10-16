package com.Incubation.Goals_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GoalsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoalsServiceApplication.class, args);
	}

}
