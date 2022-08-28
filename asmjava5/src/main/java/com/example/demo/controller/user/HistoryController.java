package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Account;
import com.example.demo.domain.CheckOut;
import com.example.demo.repository.CheckOutRepository;
import com.example.demo.service.AccountService;
import com.example.demo.service.CheckOutService;

@Controller
@RequestMapping("history")
public class HistoryController {
	@Autowired
	CheckOutService checkOutService;
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("")
	public String view(Model model, HttpSession session) {
		List<Account> listAcc = accountService.findAll();
		Account acc = new Account();
		
		for(int i = 0; i < listAcc.size(); i++) {
			if(listAcc.get(i).getId().equals(session.getAttribute("userId"))) {
				acc = listAcc.get(i);
			}
		}
		
		List<CheckOut> listHistory = checkOutService.findAll();
		List<CheckOut> newList = new ArrayList<>();
		
		for(int i = 0; i < listHistory.size(); i++) {
			if(listHistory.get(i).getAccount().getId().equals(acc.getId())) {
				newList.add(listHistory.get(i));
			}
		}
		model.addAttribute("listhistory", newList);
		model.addAttribute("username",session.getAttribute("username"));
		return "user/history";
	}
}
