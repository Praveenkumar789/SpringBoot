package com.praveen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { 
		"com.praveen.controller",
		"com.praveen.repository",
		"com.praveen.data_access_object",
		"com.praveen.model" })
public class SpringBootUserValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserValidationApplication.class, args);
	}

}
