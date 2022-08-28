package com.example.demo.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50)
	@NotEmpty(message = "username khong duoc de trong")
	private String username;
	
	@Column(length = 50)
	@NotEmpty(message = "password khong duoc de trong")
	private String password;
	
	@Column(length = 100)
	private String fullName;
	
	@Column(length = 150)
	private String email;
	
	@Column(length = 250)
	private String image;
	
	@Column
	private Boolean isAdmin;
	
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL) 
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
	private Collection<Cart> cart ;
	

	
	
}
