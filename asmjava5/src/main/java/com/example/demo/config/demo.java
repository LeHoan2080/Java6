package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.CategoryRepository;

@Controller
@RequestMapping("demo")
public class demo {

	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("")
	public String demo() {
		System.out.println(categoryRepository.findByName("admin", null));
		return"";
	}
}
