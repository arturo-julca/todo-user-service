package com.avantica.todouserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 	// It acts as a eureka client
public class TodoUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoUserServiceApplication.class, args);
	}
}
