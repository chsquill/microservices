package com.boot.web;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebAccountsService {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl = "http://MICROSERVICE-API-ACCOUNT-SERVICE";

	protected Logger logger = Logger.getLogger(WebAccountsService.class.getName());

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is " + restTemplate.getRequestFactory().getClass());
	}

	public List<Account> findAll() {
		logger.info("findAll() invoked");
		List<Account> accounts = restTemplate.getForObject(serviceUrl + "/accounts", List.class);
		return accounts;
	}

	public Account findByNumber(String accountNumber) {
		logger.info("findByNumber() invoked: for " + accountNumber);
		return restTemplate.getForObject(serviceUrl + "/accounts/number/{number}", Account.class, accountNumber);
	}

	public Account findById(Long accountId) {
		logger.info("findById() invoked: for " + accountId);
		Account account = restTemplate.getForObject(serviceUrl + "/accounts/id/{id}", Account.class, accountId);
		return account;
	}
}
