package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.domain.CheckOut;
import com.example.demo.repository.CheckOutRepository;
import com.example.demo.service.CheckOutService;

@Service
public class CheckOutServiceImpl implements CheckOutService{
	@Autowired
	CheckOutRepository checkOutRepository;

	public CheckOutServiceImpl(CheckOutRepository checkOutRepository) {
		this.checkOutRepository = checkOutRepository;
	}

	@Override
	public <S extends CheckOut> S save(S entity) {
		return checkOutRepository.save(entity);
	}

	@Override
	public <S extends CheckOut> Optional<S> findOne(Example<S> example) {
		return checkOutRepository.findOne(example);
	}

	@Override
	public List<CheckOut> findAll() {
		return checkOutRepository.findAll();
	}

	@Override
	public Page<CheckOut> findAll(Pageable pageable) {
		return checkOutRepository.findAll(pageable);
	}

	@Override
	public List<CheckOut> findAll(Sort sort) {
		return checkOutRepository.findAll(sort);
	}

	@Override
	public List<CheckOut> findAllById(Iterable<Long> ids) {
		return checkOutRepository.findAllById(ids);
	}

	@Override
	public Optional<CheckOut> findById(Long id) {
		return checkOutRepository.findById(id);
	}

	@Override
	public <S extends CheckOut> List<S> saveAll(Iterable<S> entities) {
		return checkOutRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		checkOutRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return checkOutRepository.existsById(id);
	}

	@Override
	public <S extends CheckOut> S saveAndFlush(S entity) {
		return checkOutRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends CheckOut> List<S> saveAllAndFlush(Iterable<S> entities) {
		return checkOutRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends CheckOut> Page<S> findAll(Example<S> example, Pageable pageable) {
		return checkOutRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<CheckOut> entities) {
		checkOutRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends CheckOut> long count(Example<S> example) {
		return checkOutRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<CheckOut> entities) {
		checkOutRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return checkOutRepository.count();
	}

	@Override
	public <S extends CheckOut> boolean exists(Example<S> example) {
		return checkOutRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		checkOutRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		checkOutRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(CheckOut entity) {
		checkOutRepository.delete(entity);
	}

	@Override
	public <S extends CheckOut, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return checkOutRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		checkOutRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		checkOutRepository.deleteAllInBatch();
	}

	@Override
	public CheckOut getOne(Long id) {
		return checkOutRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends CheckOut> entities) {
		checkOutRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		checkOutRepository.deleteAll();
	}

	@Override
	public CheckOut getById(Long id) {
		return checkOutRepository.getById(id);
	}

	@Override
	public CheckOut getReferenceById(Long id) {
		return checkOutRepository.getReferenceById(id);
	}

	@Override
	public <S extends CheckOut> List<S> findAll(Example<S> example) {
		return checkOutRepository.findAll(example);
	}

	@Override
	public <S extends CheckOut> List<S> findAll(Example<S> example, Sort sort) {
		return checkOutRepository.findAll(example, sort);
	}
	
	
}
