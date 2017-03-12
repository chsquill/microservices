package com.boot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceAccountServiceApplication implements CommandLineRunner {

	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAccountServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		AccountEntity entity = new AccountEntity();
		entity.setNumber("123456T");
		entity.setOwner("Chuck");
		accountRepository.save(entity);

		entity = new AccountEntity();
		entity.setNumber("123456S");
		entity.setOwner("Sue");
		accountRepository.save(entity);

	}

}
