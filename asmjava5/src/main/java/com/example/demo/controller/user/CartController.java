package com.example.demo.controller.user;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Account;
import com.example.demo.domain.Cart;
import com.example.demo.domain.CartDetail;
import com.example.demo.domain.CheckOut;
import com.example.demo.dto.CartDTO;
import com.example.demo.dto.CartDetailDTO;
import com.example.demo.dto.CheckOutDTO;
import com.example.demo.service.AccountService;
import com.example.demo.service.CartDetailService;
import com.example.demo.service.CartSevice;
import com.example.demo.service.CheckOutService;

import lombok.ToString;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/cartdetail/")
public class CartController {
	@Autowired
	JavaMailSender javaMailSender;
	
	@Autowired
	CartDetailService cartDetailService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	CartSevice cartSevice;
	
	@Autowired
	CheckOutService checkOutService;
	
	@GetMapping("/list/{id}")
	public List<CartDetailDTO> getListCartDetail(@PathVariable long id){
		List<CartDetail> listentity = cartDetailService.findAll();
		
		List<CartDetailDTO> listdto = new ArrayList<>();
		for(int i =0; i< listentity.size(); i++) {
			if(listentity.get(i).getCart().getId()== id) {	
				CartDetailDTO dto = new CartDetailDTO();
				BeanUtils.copyProperties(listentity.get(i), dto);
				dto.setCart_id(listentity.get(i).getCart().getId());
				dto.setProduct_id(listentity.get(i).getProduct().getId());
				listdto.add(dto);
			}
		}
		

		return listdto;
			
	}
	@GetMapping("/addquantity/{id}")
	public Boolean addQuantity(@PathVariable long id) {
		List<CartDetail> listentity = cartDetailService.findAll();
		for(int i =0; i< listentity.size(); i++) {
			if(listentity.get(i).getId() == id) {
				CartDetail detail = new CartDetail();
				BeanUtils.copyProperties(listentity.get(i), detail);
				detail.setQuantity(listentity.get(i).getQuantity() + 1);
				cartDetailService.save(detail);
				return true;
			}
		}
		
		
		return false;
	}
	@GetMapping("/dequantity/{id}")
	public Boolean deQuantity(@PathVariable long id) {
		List<CartDetail> listentity = cartDetailService.findAll();
		for(int i =0; i< listentity.size(); i++) {
			if(listentity.get(i).getId() == id && listentity.get(i).getQuantity() > 1) {
				CartDetail detail = new CartDetail();
				BeanUtils.copyProperties(listentity.get(i), detail);
				detail.setQuantity(listentity.get(i).getQuantity() - 1);
				cartDetailService.save(detail);
				return true;
			}
		}
		
		
		return false;
	}
	
	@GetMapping("/delete/{id}")
	public Boolean deleteCart(@PathVariable long id) {
		cartDetailService.deleteById(id);
		return false;
	}
	@GetMapping("/checkout/{id}")
	public boolean checkOut(@PathVariable long id) {
		Cart cart = cartSevice.getById(id);
		cart.setIsPresent(false);
		cartSevice.save(cart);
		return true;
		
	}
//	@GetMapping("")
//	public String view(Model model, HttpSession session) {
//		CheckOutDTO dto = new CheckOutDTO();
//		model.addAttribute("checkout",dto);
//		
//		List<CartDetail> listcartdetail = cartDetailService.findAll();
//		List<CartDetail> newListCartDetail = new ArrayList<>();
//		double total = 0;
//		for(int i = 0; i < listcartdetail.size(); i++) {
//			if(listcartdetail.get(i).getCart().getId().equals(session.getAttribute("cartId"))) {
//				newListCartDetail.add(listcartdetail.get(i));
//				total = total + listcartdetail.get(i).getProduct().getPrice()*listcartdetail.get(i).getQuantity();
//			}
//		}
//		
//		model.addAttribute("cartDetail", newListCartDetail);
//		model.addAttribute("total", total);
//		model.addAttribute("username",session.getAttribute("username"));
//		return "user/cart";
//	}
//	
//	@GetMapping("adQuantity/{id}")
//	public String adQuantity(@PathVariable("id") Long id) {
//		CartDetail cartDetail = cartDetailService.getById(id);
//		
//		cartDetail.setQuantity(cartDetail.getQuantity() + 1);
//		
//		cartDetailService.save(cartDetail);
//		
//		
//		
//		return "redirect:/cart";
//	}
//	
//	@GetMapping("deQuantity/{id}")
//	public String deQuantity(@PathVariable("id") Long id) {
//		
//		CartDetail cartDetail = cartDetailService.getById(id);
//		
//		if(cartDetail.getQuantity() == 1) {
//			return "redirect:/cart";
//		} else {
//			cartDetail.setQuantity(cartDetail.getQuantity() - 1);
//			
//			cartDetailService.save(cartDetail);
//		}
//		return "redirect:/cart";
//	}
//	
//	@GetMapping("delete/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		
//		cartDetailService.deleteById(id);
//		return "redirect:/cart";
//	}
//	
//	@PostMapping("checkout")
//	public String checkOut(Model model, HttpSession session, CheckOutDTO dto) {
//		
//		session.getAttribute("userId");
//		session.getAttribute("cartId");
//		if(session.getAttribute("userId") != null && session.getAttribute("cartId") != null) {
//			
//			if(dto.getAddress().isEmpty() || dto.getPhoneNumber().isEmpty()) {
//				return "redirect:/cart";
//			}
//			
//			List<Account> listAccount = accountService.findAll();
//			Account accont = new Account();
//			for(int i = 0; i < listAccount.size(); i++) {
//				if(listAccount.get(i).getId().equals(session.getAttribute("userId"))) {
//					accont = listAccount.get(i);
//				}
//			}
//			List<Cart> listCart = cartSevice.findAll();
//			Cart cart = new Cart();
//			for(int i = 0; i< listCart.size(); i++) {
//				if(listCart.get(i).getId().equals(session.getAttribute("cartId"))) {
//					cart = listCart.get(i);
//				}
//			}
//			String pattern = "MM/dd/yyyy HH:mm:ss";
//			DateFormat df = new SimpleDateFormat(pattern);
//			Date today = Calendar.getInstance().getTime(); 
//			String todayAsString = df.format(today);
//			
//			CheckOut entity = new CheckOut();
//			BeanUtils.copyProperties(dto, entity);
//			entity.setAccount(accont);
//			entity.setCart(cart);
//			entity.setTime(todayAsString);
//			
//			List<CartDetail> listcartdetail = cartDetailService.findAll();
//			double total = 0;
//			for(int i = 0; i < listcartdetail.size(); i++) {
//				if(listcartdetail.get(i).getCart().getId().equals(session.getAttribute("cartId"))) {
//					total = total + listcartdetail.get(i).getProduct().getPrice()*listcartdetail.get(i).getQuantity();
//				}
//			}
//			
//			entity.setTotal(total);
//			checkOutService.save(entity);
//			
//			cart.setIsPresent(false);
//			cart.setAccount(accont);
//			cartSevice.save(cart);
//			
//			SimpleMailMessage msg = new SimpleMailMessage();
//			msg.setTo(accont.getEmail());
//			msg.setSubject("Don hang thoi gian: " + todayAsString);
//			msg.setText("tong tien cua khach hang: " + total + "gui toi dia chi: " + dto.getAddress() + "voi sdt: " + dto.getPhoneNumber());
//			javaMailSender.send(msg);
//			
//			session.removeAttribute("cartId");
//			
//			return "redirect:/home";
//		}
//		
//		return "redirect:/cart";
//	}
}
