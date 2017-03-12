package com.boot.web;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(AccountsController.class.getName());

	@RequestMapping("/accounts")
	public List<Account> all() {

		logger.info("accounts-service all() invoked");

		Account account = new Account();
		account.setId(1);
		account.setNumber("123456T");
		account.setOwner("Chuck");

		Account account2 = new Account();
		account2.setId(21);
		account2.setNumber("123456S");
		account2.setOwner("Sue");

		List<Account> list = new ArrayList<Account>();
		list.add(account);
		list.add(account2);

		logger.info("accounts-service all() found");

		return list;
	}

	@RequestMapping("/accounts/{accountNumber}")
	public Account byNumber(@PathVariable("accountNumber") String accountNumber) {

		logger.info("accounts-service byNumber() invoked: " + accountNumber);

		Account account = new Account();
		account.setId(1);
		account.setNumber("123456T");
		account.setOwner("Chuck");

		logger.info("accounts-service byNumber() found: " + account);

		return account;
	}
}
