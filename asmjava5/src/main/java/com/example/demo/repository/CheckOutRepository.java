package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.CheckOut;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOut, Long>{

}
