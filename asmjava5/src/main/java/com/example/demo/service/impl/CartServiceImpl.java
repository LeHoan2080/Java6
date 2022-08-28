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

import com.example.demo.domain.Cart;
import com.example.demo.repository.CartRepository;
import com.example.demo.service.CartSevice;

@Service
public class CartServiceImpl implements CartSevice{
	CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}



	@Override
	public <S extends Cart> S save(S entity) {
		return cartRepository.save(entity);
	}

	@Override
	public <S extends Cart> Optional<S> findOne(Example<S> example) {
		return cartRepository.findOne(example);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public Page<Cart> findAll(Pageable pageable) {
		return cartRepository.findAll(pageable);
	}

	@Override
	public List<Cart> findAll(Sort sort) {
		return cartRepository.findAll(sort);
	}

	@Override
	public List<Cart> findAllById(Iterable<Long> ids) {
		return cartRepository.findAllById(ids);
	}

	@Override
	public Optional<Cart> findById(Long id) {
		return cartRepository.findById(id);
	}

	@Override
	public <S extends Cart> List<S> saveAll(Iterable<S> entities) {
		return cartRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		cartRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return cartRepository.existsById(id);
	}

	@Override
	public <S extends Cart> S saveAndFlush(S entity) {
		return cartRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Cart> List<S> saveAllAndFlush(Iterable<S> entities) {
		return cartRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Cart> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cartRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Cart> entities) {
		cartRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Cart> long count(Example<S> example) {
		return cartRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Cart> entities) {
		cartRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return cartRepository.count();
	}

	@Override
	public <S extends Cart> boolean exists(Example<S> example) {
		return cartRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		cartRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		cartRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Cart entity) {
		cartRepository.delete(entity);
	}

	@Override
	public <S extends Cart, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return cartRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		cartRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		cartRepository.deleteAllInBatch();
	}

	@Override
	public Cart getOne(Long id) {
		return cartRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Cart> entities) {
		cartRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cartRepository.deleteAll();
	}

	@Override
	public Cart getById(Long id) {
		return cartRepository.getById(id);
	}

	@Override
	public Cart getReferenceById(Long id) {
		return cartRepository.getReferenceById(id);
	}

	@Override
	public <S extends Cart> List<S> findAll(Example<S> example) {
		return cartRepository.findAll(example);
	}

	@Override
	public <S extends Cart> List<S> findAll(Example<S> example, Sort sort) {
		return cartRepository.findAll(example, sort);
	}
	
	
	
}
