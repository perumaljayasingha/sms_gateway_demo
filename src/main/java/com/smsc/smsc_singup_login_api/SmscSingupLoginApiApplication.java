package com.smsc.smsc_singup_login_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.smsc.smsc_singup_login_api.repositories")
public class SmscSingupLoginApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmscSingupLoginApiApplication.class, args);
		System.out.println("App Started...");
	}

}
