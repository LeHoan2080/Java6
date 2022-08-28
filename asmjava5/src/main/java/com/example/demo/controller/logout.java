package com.example.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("logout")
public class logout {
	
	@GetMapping("")
	public String logOut(HttpSession session) {
		
		session.removeAttribute("username");
		session.removeAttribute("userId");
		session.removeAttribute("cartId");
		session.removeAttribute("isAdmin");
		
		return "redirect:/home";
	}
}
