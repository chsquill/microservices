package com.boot.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	List<Account> findAll() {

		List<Account> accounts = new ArrayList<Account>();

		List<AccountEntity> entity = accountRepository.findAll();

		for (AccountEntity accountEntity : entity) {
			accounts.add(toBean(accountEntity));
		}

		return accounts;
	}

	Account findById(long id) {

		AccountEntity entity = accountRepository.findOne(id);

		Account account = toBean(entity);

		return account;
	}

	Account findByNumber(String number) {

		AccountEntity entity = accountRepository.findByNumber(number);

		Account account = toBean(entity);

		return account;
	}

	private Account toBean(AccountEntity entity) {

		Account account = null;

		if (entity != null) {
			account = new Account();
			account.setId(entity.getId());
			account.setNumber(entity.getNumber());
			account.setOwner(entity.getOwner());
		}
		return account;
	}
}
