package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	@Query("SELECT u FROM Account u WHERE u.username = :username and u.password = :password")
	public Account checkLogin(@Param("username") String username, @Param("password") String password);
	
	
}
