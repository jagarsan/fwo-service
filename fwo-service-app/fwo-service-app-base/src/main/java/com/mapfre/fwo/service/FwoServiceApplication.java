package com.mapfre.fwo.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class FwoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FwoServiceApplication.class, args);
	}
	
}
