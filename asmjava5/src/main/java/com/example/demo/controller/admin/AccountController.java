package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.AES;
import com.example.demo.domain.Account;
import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.AccountService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/admin/accounts/")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	@PostMapping("/list")
	public List<AccountDTO> getAllAccount(@RequestBody AccountDTO account){
		 
		 List<AccountDTO> listdto = new ArrayList<>();
		if(account.getIsAdmin() == true) {
			List<Account> accounts = accountService.findAll();
			for( int i = 0 ; i < accounts.size(); i++ ) {
				AccountDTO dto = new AccountDTO();
				BeanUtils.copyProperties(accounts.get(i), dto);
				dto.setPassword(AES.decrypt(accounts.get(i).getPassword(), "12345"));
				listdto.add(dto);             
			}
			return listdto;
		}
		return null;
	}
	
	@PostMapping("/save/{isAdmin}")
	public Boolean createProduct(@RequestBody AccountDTO dto,@PathVariable long isAdmin) {
		if(isAdmin == 1) {
			Account account = new Account();
			BeanUtils.copyProperties(dto, account);
			account.setPassword(AES.encrypt(dto.getPassword(), "12345"));
			accountService.save(account);
			return true;
		} else {
			return false;
		}
	}
	@GetMapping("/view/{id}")
	public AccountDTO getById(@PathVariable long id) {
		AccountDTO dto = new AccountDTO();
		Account entity = accountService.getById(id);
		BeanUtils.copyProperties(entity, dto);
		dto.setPassword(AES.decrypt(entity.getPassword(), "12345"));
		return dto;
	}
	@PostMapping("/delete/{id}")
	public Boolean delete(@PathVariable long id, @RequestBody AccountDTO dto) {
		if(dto.getIsAdmin() == true) {
			accountService.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}
//	@GetMapping("add")
//	public String add(Model model) {
//		
//		model.addAttribute("account", new AccountDTO());
//		
//		return "admin/accounts/addEdit";
//	}
//	
//	@GetMapping("edit/{id}")
//	public String edit(Model model, @PathVariable("id") Long id) {
//		Optional<Account> opt = accountService.findById(id);
//		AccountDTO dto = new AccountDTO();
//		
//		if(opt.isPresent()) {
//			Account entity = opt.get();
//			entity.setPassword(AES.decrypt(entity.getPassword(), "12345"));
//			BeanUtils.copyProperties(entity, dto);
//			
//			model.addAttribute("account", dto);
//			
//			return "admin/accounts/addEdit";
//		}
//		return "admin/accounts/addEdit";
//	}
//	
//	@PostMapping("saveUpdate")
//	public String saveUpdate(Model model, AccountDTO dto) {
//		List<Account> list = accountService.findAll();
//		for(int i = 0; i< list.size(); i++) {
//			if(list.get(i).getEmail().equals(dto.getEmail())) {
//				model.addAttribute("message", "mail da ton tai tai tai khoan khac");  
//				
//				model.addAttribute("account", new AccountDTO());
//				return "admin/accounts/addEdit";
//			}
//			if(list.get(i).getUsername().equals(dto.getUsername())) {
//				model.addAttribute("message", "tai khoan da ton tai");  
//				
//				model.addAttribute("account", new AccountDTO());
//				return "admin/accounts/addEdit";
//			}
//		}
//		Account entity = new Account();
//		dto.setPassword(AES.encrypt(dto.getPassword(), "12345"));
//		BeanUtils.copyProperties(dto, entity);
//		
//		accountService.save(entity);
//		return "redirect:/admin/accounts";
//	}
//	
//	@GetMapping("delete/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		accountService.deleteById(id);
//		return "redirect:/admin/accounts";
//	}
//		
//	@GetMapping("")
//	public String list(Model model,@RequestParam("p") Optional<Integer> p) {
//		Pageable pageable = PageRequest.of(p.orElse(0), 5);
//		Page<Account> page = accountService.findAll(pageable);
//		List<Account> list = accountService.findAll();
//		
//		model.addAttribute("accounts",page);
//		
//		return "admin/accounts/list";
//	}
//	
}
