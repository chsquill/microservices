package com.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MicroserviceWebClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceWebClientApplication.class, args);
	}

	/*
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
