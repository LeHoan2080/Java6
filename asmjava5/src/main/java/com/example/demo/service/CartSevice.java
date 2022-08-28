package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.demo.domain.Cart;

public interface CartSevice {

	<S extends Cart> List<S> findAll(Example<S> example, Sort sort);

	<S extends Cart> List<S> findAll(Example<S> example);

	Cart getReferenceById(Long id);

	Cart getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Cart> entities);

	Cart getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Cart, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Cart entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Cart> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Cart> entities);

	<S extends Cart> long count(Example<S> example);

	void deleteInBatch(Iterable<Cart> entities);

	<S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Cart> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Cart> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Cart> List<S> saveAll(Iterable<S> entities);

	Optional<Cart> findById(Long id);

	List<Cart> findAllById(Iterable<Long> ids);

	List<Cart> findAll(Sort sort);

	Page<Cart> findAll(Pageable pageable);

	List<Cart> findAll();

	<S extends Cart> Optional<S> findOne(Example<S> example);

	<S extends Cart> S save(S entity);



}
