package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.AES;
import com.example.demo.domain.Account;
import com.example.demo.dto.AccountDTO;
import com.example.demo.service.AccountService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/register/")
public class RegisterController {
	@Autowired
	AccountService accountService;
	
//	@GetMapping("")
//	public String register(Model model){
//		model.addAttribute("account", new AccountDTO());
//		return "loginRegister/register";
//	}
//	
	@PostMapping("/submit")
	public Boolean saveRegister(@RequestBody AccountDTO dto) {
		
		System.out.println(dto);
		
		if(dto.getEmail().isEmpty() || dto.getFullName().isEmpty() || dto.getImage().isEmpty() || dto.getUsername().isEmpty() || dto.getPassword().isEmpty()) {
			return false;
		}
		List<Account> list = accountService.findAll();
		for(int i = 0; i< list.size(); i++) {
			if(list.get(i).getEmail().equals(dto.getEmail())) {
				
				return false;
			}
			if(list.get(i).getUsername().equals(dto.getUsername())) {
			
				return false;
			}
		}
		Account entity = new Account();
		dto.setIsAdmin(false);
		dto.setPassword(AES.encrypt(dto.getPassword(), "12345"));
		BeanUtils.copyProperties(dto, entity);
		
		accountService.save(entity);
		return true;
	}
	}
