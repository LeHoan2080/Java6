package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Account;
import com.example.demo.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
