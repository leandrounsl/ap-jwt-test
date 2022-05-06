package com.argentina.programa.jwt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class JwtTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtTestApplication.class, args);
	}

}
