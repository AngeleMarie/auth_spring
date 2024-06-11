package com.angele.auth_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApiApplication.class, args);
		
	
	}
@Bean
CommandLineRunner commandLineRunner() {
	return args->{};
}
}
