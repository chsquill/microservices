package com.boot.web;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class.getName());

	@Autowired
	AccountService accountService;

	@RequestMapping("/accounts")
	public List<Account> all() {

		logger.info("accounts-service all() invoked");

		return accountService.findAll();
	}

	@RequestMapping("/accounts/number/{accountNumber}")
	public Account byNumber(@PathVariable("accountNumber") String number) {

		logger.info("accounts-service byNumber() invoked: " + number);

		return accountService.findByNumber(number);
	}

	@RequestMapping("/accounts/id/{id}")
	public Account byId(@PathVariable("id") long id) {

		logger.info("accounts-service byId() invoked: " + id);

		return accountService.findById(id);
	}
}
