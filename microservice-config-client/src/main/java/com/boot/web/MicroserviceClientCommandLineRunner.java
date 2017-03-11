package com.boot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MicroserviceClientCommandLineRunner implements CommandLineRunner {

	@Value("${message}")
	String test;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(test);
	}

}
