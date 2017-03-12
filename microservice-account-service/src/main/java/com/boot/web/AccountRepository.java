package com.boot.web;

import java.util.List;

import org.springframework.data.repository.Repository;

interface AccountRepository extends Repository<AccountEntity, Long> {

	List<AccountEntity> findAll();

	AccountEntity findOne(long id);

	AccountEntity findByNumber(String number);

	AccountEntity save(AccountEntity entity);

}
