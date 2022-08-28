package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Account;
import com.example.demo.domain.Cart;
import com.example.demo.domain.CartDetail;
import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.AccountService;
import com.example.demo.service.CartDetailService;
import com.example.demo.service.CartSevice;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/home/products/")
public class HomeController {
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartSevice cartSevice;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CartDetailService cartDetailService;
	
	@GetMapping("/list")
	public List<ProductDTO> getAllProduct(){
		List<Product> products = productService.findAll();
		List<ProductDTO> listdto = new ArrayList<>();
		for( int i = 0 ; i < products.size(); i++ ) {
			ProductDTO dto = new ProductDTO();
			BeanUtils.copyProperties(products.get(i), dto);
			dto.setCategory_id(products.get(i).getCategory().getCategory_id());
			listdto.add(dto);             
		}
		
		return listdto;
	}
	
	@GetMapping("/view/{id}")
	public ProductDTO getProductById(@PathVariable long id) {
		ProductDTO dto = new ProductDTO();
		Product entity = productService.getById(id);
		BeanUtils.copyProperties(entity, dto);
		dto.setCategory_id(entity.getCategory().getCategory_id());
		return dto;
		
		
	}
	@GetMapping("/categories")
	public List<CategoryDTO> getListCategories(){
		List<Category> entity = categoryService.findAll();
		List<CategoryDTO> Listdto = new ArrayList<>();
		for(int i = 0; i< entity.size(); i++) {
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(entity.get(i), dto);
			Listdto.add(dto);
		}
		return Listdto;
	}
	
//	@ModelAttribute("categories")
//	public List<CategoryDTO> getCategories(){
//		return categoryService.findAll().stream().map(item ->{
//			CategoryDTO dto = new CategoryDTO();
//			BeanUtils.copyProperties(item, dto);
//			return dto;
//		}).toList();
//	}
//	
//
//	
	@PostMapping("/getcart")
	public CartDTO getCart(@RequestBody AccountDTO account) {
		List<Cart> listcartentitty = cartSevice.findAll();
		List<Account> listaccountentity = accountService.findAll();
		Account acountdomain = new Account();
		CartDTO dto = new CartDTO();
		
		for(int i = 0; i < listcartentitty.size(); i++) {
			if(listcartentitty.get(i).getAccount().getId() == account.getId()) {
				if(listcartentitty.get(i).getIsPresent()==true) {
					BeanUtils.copyProperties(listcartentitty.get(i), dto);
					dto.setAccount_id(account.getId());
					return dto;
				}
			} 
		}
		
		for(int i = 0; i<listaccountentity.size(); i++) {
			if(listaccountentity.get(i).getId() == account.getId()) {
				BeanUtils.copyProperties(listaccountentity.get(i), acountdomain);
			}
		}
		
		Cart cart = new Cart();
		cart.setIsPresent(true);
		cart.setAccount(acountdomain);
		cartSevice.save(cart);
		BeanUtils.copyProperties(cart, dto);
		dto.setAccount_id(account.getId());
		
		return dto;
	}
	
	@PostMapping("/addcart/{productid}")
	public Boolean addCart(@PathVariable long productid, @RequestBody CartDTO cart) {
		List<Product> listproduct = productService.findAll();
		List<Cart> listCart = cartSevice.findAll();
		List<CartDetail> listcartdetail = cartDetailService.findAll();
		
		Product product = new Product();
		CartDetail cartDetaildomain = new CartDetail();
		Cart cartdomain = new Cart();
		
		for(int i =0; i< listproduct.size(); i++) {
			if(listproduct.get(i).getId() == productid) {
				BeanUtils.copyProperties(listproduct.get(i), product);
			}
		}
		
		for(int i =0; i< listCart.size(); i++) {
			if(listCart.get(i).getId() == cart.getId()) {
				BeanUtils.copyProperties(listCart.get(i), cartdomain);
			}
		}
		
		for(int i =0; i< listcartdetail.size(); i++) {
			if(listcartdetail.get(i).getCart().getId() == cart.getId()) {
				System.out.println("hahah" + listcartdetail.get(i));
				if(listcartdetail.get(i).getProduct().getId() == productid) {
					BeanUtils.copyProperties(listcartdetail.get(i), cartDetaildomain);
					cartDetaildomain.setQuantity(cartDetaildomain.getQuantity() + 1);
					cartDetailService.save(cartDetaildomain);
					return true;
				}
			}
		}
		
		cartDetaildomain.setCart(cartdomain);
		cartDetaildomain.setProduct(product);
		cartDetaildomain.setQuantity((long) 1);
		System.out.println(cartDetaildomain);
		cartDetailService.save(cartDetaildomain);
		return true;
	}
	 
//	@GetMapping("")
//	public String home(Model model,HttpSession session) {
//		List<Product> list = productService.findAll();
//		List<Cart> listcart = cartSevice.findAll(); 
//		List<Account> listaccount = accountService.findAll();
//		Cart cart = new Cart();
//		
//		model.addAttribute("username",session.getAttribute("username"));
//		
//		model.addAttribute("products", list);
//		int isdemo = 0;
//				
//		Account account = new Account();
//		
//		for(int i = 0; i < listaccount.size(); i++) {
//			if(listaccount.get(i).getId().equals(session.getAttribute("userId"))) {
//				account = listaccount.get(i);
//				 isdemo = 100;
//			}
//		}
//		
//		for(int i = 0; i < listcart.size(); i++) {
//			if(listcart.get(i).getAccount().getId().equals(session.getAttribute("userId")) && listcart.get(i).getIsPresent().equals(true) ) {
//				cart = listcart.get(i);
//				session.setAttribute("cartId", listcart.get(i).getId());
//			}
//		}
//		
//		if(cart.getIsPresent() == null && isdemo == 100) {
//			cart.setIsPresent(true);
//			cart.setAccount(account);
//			cartSevice.save(cart);
//		}
//		return "user/home";
//	}
//	
//	@GetMapping("viewDetail/{id}")
//	public String viewDetail(Model model, @PathVariable("id") Long id, HttpSession session) {
//		
//		Optional<Product> opt = productService.findById(id);
//		
//		ProductDTO dto = new ProductDTO();
//		
//		if(opt.isPresent()) {
//			Product entity = opt.get();
//			BeanUtils.copyProperties(entity, dto);
//			
//			model.addAttribute("product", dto);
//			model.addAttribute("username",session.getAttribute("username"));
//			
//			return "user/viewdetail";
//		}
//		
//		return "user/viewdetail";
//	}
//	
//	@GetMapping("getProductByCategory/{id}")
//	public String getProductByCategory(Model model, @PathVariable("id") Long categoryid) {
//		List<Product> list = productService.findAll();
//		List<Product> getProductId = new ArrayList<Product>(); 
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getCategory().getCategory_id() == categoryid) {
//				getProductId.add(list.get(i));
//				model.addAttribute("products", getProductId);
//			}
//		}
//		
//		return "user/home";
//	}
//	
//	@GetMapping("addCart/{product_id}")
//	public String addCart(HttpSession session, @PathVariable("product_id") Long product_id) {
//		Product product = productService.getById(product_id);
//		List<Cart> listcart = cartSevice.findAll(); 
//		List<CartDetail> listcartdetail = cartDetailService.findAll();
//		
//
//
//		session.getAttribute("userId");
//		session.getAttribute("username");
//
//		
//		Cart cart = new Cart();
//		
//		for(int i = 0; i < listcart.size(); i++) {
//			if(listcart.get(i).getAccount().getId().equals(session.getAttribute("userId")) && listcart.get(i).getIsPresent().equals(true) ) {
//				cart = listcart.get(i);
//			}
//		}
//		
//		CartDetail cartDetail = new CartDetail();
//		
//		for(int i = 0; i< listcartdetail.size(); i++) {
//			if(listcartdetail.get(i).getCart().getIsPresent() == true && listcartdetail.get(i).getProduct().getId().equals(product_id)) {
//				
//				cartDetail.setId(listcartdetail.get(i).getId());
//				cartDetail.setProduct(product);
//				cartDetail.setCart(listcartdetail.get(i).getCart());
//				cartDetail.setQuantity(listcartdetail.get(i).getQuantity() + 1);
//				
//				cartDetailService.save(cartDetail);
//				return "redirect:/home";
//				
//			} 
//		}
//		cartDetail.setCart(cart);
//		cartDetail.setProduct(product);
//		cartDetail.setQuantity((long) 1);
//		
//		cartDetailService.save(cartDetail);
//		
//		
//		return "redirect:/home";
//	}
//	
//	@PostMapping("search")
//	public String search(@RequestParam("name") String name, Model model) {
//		List<Product> list = productService.findAll();
//		List<Product> newList = new ArrayList<>();
//		
//		for(int i = 0; i < list.size(); i++) {
//			if(list.get(i).getName().equalsIgnoreCase(name)) {
//				newList.add(list.get(i));
//			}
//		}
//		
//		model.addAttribute("products", newList);
//		
//		return "user/home";
//	}
}
