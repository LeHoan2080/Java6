package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.AdminAuthenInterceptor;
import com.example.demo.interceptor.UserAuthenIntercepter;

@Configuration
public class AuthenInterceptorConfig implements WebMvcConfigurer{
	@Autowired
	AdminAuthenInterceptor adminAuthenInterceptor;
	
	@Autowired
	UserAuthenIntercepter userAuthenIntercepter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(adminAuthenInterceptor)
//		.addPathPatterns("/admin/**");
//		registry.addInterceptor(userAuthenIntercepter)
//		.addPathPatterns("/home/addCart/**")
//		.addPathPatterns("/cart/**");
	}
	
	
}
