package com.civicsenseco.smsc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.civicsenseco.smsc.repositories")
public class SmscUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmscUserApplication.class, args);
		System.out.println("App Started...");
	}

}
