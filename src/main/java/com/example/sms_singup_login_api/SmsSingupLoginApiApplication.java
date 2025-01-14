package com.example.sms_singup_login_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.sms_singup_login_api.repositoryClasses")
public class SmsSingupLoginApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsSingupLoginApiApplication.class, args);
		System.out.println("App Started...");
	}

}
