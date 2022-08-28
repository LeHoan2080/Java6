package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.AES;
import com.example.demo.domain.Account;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.service.AccountService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/login/")
public class AdminLoginController {
	@Autowired
	AccountService accountService;
	
//	@GetMapping("")
//	public String LoginPage(Model model) {
//		model.addAttribute("account", new LoginDTO());
//		
//		return "loginRegister/login";
//	}
//	
	@PostMapping("/checklogin")
	public AccountDTO chekLogin(@RequestBody LoginDTO login) {
		System.out.print(login);
		
		
		if(login.getUsername().isEmpty() || login.getPassword().isEmpty()) {
			return null;
		}
		
		Account check = accountService.checkLogin(login.getUsername(), AES.encrypt(login.getPassword(), "12345"));
		if(check == null) {
			return null;
		}else {
			AccountDTO dto = new AccountDTO();
			BeanUtils.copyProperties(check, dto);
			dto.setPassword(AES.decrypt(check.getPassword(), "12345"));
			return dto;
		}
	}
	
}
