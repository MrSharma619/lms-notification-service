package com.example.lmsnotificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LmsNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsNotificationServiceApplication.class, args);
	}

}
