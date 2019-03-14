package com.avantica.todouserservice;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.avantica.todouserservice.model.AppUser;
import com.avantica.todouserservice.repository.AppUserRepository;

@SpringBootApplication
@EnableEurekaClient 	// It acts as a eureka client
public class TodoUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoUserServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AppUserRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 3)
					.mapToObj(i -> new AppUser(i, "admin"+ i, "12345", "ADMIN"))
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};
	}
}
