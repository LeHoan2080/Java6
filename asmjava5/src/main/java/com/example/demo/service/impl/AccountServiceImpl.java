package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	AccountRepository accountRepository;

	
	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	@Override
	public Account checkLogin(String username, String password) {
        return accountRepository.checkLogin(username, password);
    }

	@Override
	public <S extends Account> S save(S entity) {
		return accountRepository.save(entity);
	}

	@Override
	public <S extends Account> Optional<S> findOne(Example<S> example) {
		return accountRepository.findOne(example);
	}

	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}

	@Override
	public Page<Account> findAll(Pageable pageable) {
		return accountRepository.findAll(pageable);
	}

	@Override
	public List<Account> findAll(Sort sort) {
		return accountRepository.findAll(sort);
	}

	@Override
	public List<Account> findAllById(Iterable<Long> ids) {
		return accountRepository.findAllById(ids);
	}

	@Override
	public Optional<Account> findById(Long id) {
		return accountRepository.findById(id);
	}

	@Override
	public <S extends Account> List<S> saveAll(Iterable<S> entities) {
		return accountRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		accountRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return accountRepository.existsById(id);
	}

	@Override
	public <S extends Account> S saveAndFlush(S entity) {
		return accountRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Account> List<S> saveAllAndFlush(Iterable<S> entities) {
		return accountRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Account> Page<S> findAll(Example<S> example, Pageable pageable) {
		return accountRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Account> entities) {
		accountRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Account> long count(Example<S> example) {
		return accountRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Account> entities) {
		accountRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return accountRepository.count();
	}

	@Override
	public <S extends Account> boolean exists(Example<S> example) {
		return accountRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		accountRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Account entity) {
		accountRepository.delete(entity);
	}

	@Override
	public <S extends Account, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return accountRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		accountRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		accountRepository.deleteAllInBatch();
	}

	@Override
	public Account getOne(Long id) {
		return accountRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Account> entities) {
		accountRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		accountRepository.deleteAll();
	}

	@Override
	public Account getById(Long id) {
		return accountRepository.getById(id);
	}

	@Override
	public Account getReferenceById(Long id) {
		return accountRepository.getReferenceById(id);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example) {
		return accountRepository.findAll(example);
	}

	@Override
	public <S extends Account> List<S> findAll(Example<S> example, Sort sort) {
		return accountRepository.findAll(example, sort);
	}
	
	
	
}
