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

import com.example.demo.domain.CartDetail;
import com.example.demo.repository.CartDetailRepository;
import com.example.demo.service.CartDetailService;

@Service
public class CartDetailServiceImpl implements CartDetailService{
	CartDetailRepository cartDetailRepository;

	public CartDetailServiceImpl(CartDetailRepository cartDetailRepository) {
		this.cartDetailRepository = cartDetailRepository;
	}

	@Override
	public <S extends CartDetail> S save(S entity) {
		return cartDetailRepository.save(entity);
	}

	@Override
	public <S extends CartDetail> Optional<S> findOne(Example<S> example) {
		return cartDetailRepository.findOne(example);
	}

	@Override
	public List<CartDetail> findAll() {
		return cartDetailRepository.findAll();
	}

	@Override
	public Page<CartDetail> findAll(Pageable pageable) {
		return cartDetailRepository.findAll(pageable);
	}

	@Override
	public List<CartDetail> findAll(Sort sort) {
		return cartDetailRepository.findAll(sort);
	}

	@Override
	public List<CartDetail> findAllById(Iterable<Long> ids) {
		return cartDetailRepository.findAllById(ids);
	}

	@Override
	public Optional<CartDetail> findById(Long id) {
		return cartDetailRepository.findById(id);
	}

	@Override
	public <S extends CartDetail> List<S> saveAll(Iterable<S> entities) {
		return cartDetailRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		cartDetailRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return cartDetailRepository.existsById(id);
	}

	@Override
	public <S extends CartDetail> S saveAndFlush(S entity) {
		return cartDetailRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends CartDetail> List<S> saveAllAndFlush(Iterable<S> entities) {
		return cartDetailRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends CartDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
		return cartDetailRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<CartDetail> entities) {
		cartDetailRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends CartDetail> long count(Example<S> example) {
		return cartDetailRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<CartDetail> entities) {
		cartDetailRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return cartDetailRepository.count();
	}

	@Override
	public <S extends CartDetail> boolean exists(Example<S> example) {
		return cartDetailRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		cartDetailRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		cartDetailRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(CartDetail entity) {
		cartDetailRepository.delete(entity);
	}

	@Override
	public <S extends CartDetail, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return cartDetailRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		cartDetailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		cartDetailRepository.deleteAllInBatch();
	}

	@Override
	public CartDetail getOne(Long id) {
		return cartDetailRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends CartDetail> entities) {
		cartDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		cartDetailRepository.deleteAll();
	}

	@Override
	public CartDetail getById(Long id) {
		return cartDetailRepository.getById(id);
	}

	@Override
	public CartDetail getReferenceById(Long id) {
		return cartDetailRepository.getReferenceById(id);
	}

	@Override
	public <S extends CartDetail> List<S> findAll(Example<S> example) {
		return cartDetailRepository.findAll(example);
	}

	@Override
	public <S extends CartDetail> List<S> findAll(Example<S> example, Sort sort) {
		return cartDetailRepository.findAll(example, sort);
	}
	
	
	
}
