package com.example.demo.service;



import java.util.List;

import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;

public interface CategoryService {

	Category getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Category> entities);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Category entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Category> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Category> entities);

	<S extends Category> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Category> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Category> List<S> saveAll(Iterable<S> entities);

	Optional<Category> findById(Long id);

	List<Category> findAllById(Iterable<Long> ids);

	List<Category> findAll(Sort sort);

	Page<Category> findAll(Pageable pageable);

	List<Category> findAll();

	<S extends Category> S save(S entity);


}
