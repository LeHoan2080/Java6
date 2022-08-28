package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.demo.domain.CheckOut;

public interface CheckOutService {

	<S extends CheckOut> List<S> findAll(Example<S> example, Sort sort);

	<S extends CheckOut> List<S> findAll(Example<S> example);

	CheckOut getReferenceById(Long id);

	CheckOut getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends CheckOut> entities);

	CheckOut getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends CheckOut, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(CheckOut entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends CheckOut> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<CheckOut> entities);

	<S extends CheckOut> long count(Example<S> example);

	void deleteInBatch(Iterable<CheckOut> entities);

	<S extends CheckOut> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends CheckOut> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends CheckOut> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends CheckOut> List<S> saveAll(Iterable<S> entities);

	Optional<CheckOut> findById(Long id);

	List<CheckOut> findAllById(Iterable<Long> ids);

	List<CheckOut> findAll(Sort sort);

	Page<CheckOut> findAll(Pageable pageable);

	List<CheckOut> findAll();

	<S extends CheckOut> Optional<S> findOne(Example<S> example);

	<S extends CheckOut> S save(S entity);

}
