package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "checkout")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckOut {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 500)
	private String address;
	
	@Column(length = 12)
	private String phoneNumber;
	
	@Column
	private String time;
	
	@Column
	private Double total;
	
	@ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
	
	@ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;



}
