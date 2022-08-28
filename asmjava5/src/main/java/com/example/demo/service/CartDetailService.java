package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.example.demo.domain.CartDetail;

public interface CartDetailService {

	<S extends CartDetail> List<S> findAll(Example<S> example, Sort sort);

	<S extends CartDetail> List<S> findAll(Example<S> example);

	CartDetail getReferenceById(Long id);

	CartDetail getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends CartDetail> entities);

	CartDetail getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends CartDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(CartDetail entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends CartDetail> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<CartDetail> entities);

	<S extends CartDetail> long count(Example<S> example);

	void deleteInBatch(Iterable<CartDetail> entities);

	<S extends CartDetail> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends CartDetail> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends CartDetail> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends CartDetail> List<S> saveAll(Iterable<S> entities);

	Optional<CartDetail> findById(Long id);

	List<CartDetail> findAllById(Iterable<Long> ids);

	List<CartDetail> findAll(Sort sort);

	Page<CartDetail> findAll(Pageable pageable);

	List<CartDetail> findAll();

	<S extends CartDetail> Optional<S> findOne(Example<S> example);

	<S extends CartDetail> S save(S entity);

}
