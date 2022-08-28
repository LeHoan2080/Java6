package com.example.demo.controller.admin;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.interceptor.ResourceNotFoundException;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/admin/products/")
public class ProductController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/save/{isAdmin}")
	public Boolean createProduct(@RequestBody ProductDTO dto,@PathVariable long isAdmin) {
		if(isAdmin == 1) {
			Product product = new Product();
			List<Category> listcate = categoryService.findAll();
			Category cate = new Category();
			for(int i = 0; i< listcate.size() ; i++) {
				if(listcate.get(i).getCategory_id() == dto.getCategory_id()) {
					BeanUtils.copyProperties(listcate.get(i), cate);
				}
			}
			BeanUtils.copyProperties(dto, product);
			product.setCategory(cate);
			productService.save(product);
			return true;
		} else {
			return false;
		}
	}
	
	@PostMapping("/delete/{id}")
	public Boolean deleteProducts(@PathVariable long id, @RequestBody AccountDTO dto) {
		if(dto.getIsAdmin() == true) {
			productService.deleteById(id);
			return true;
		} else {
			return false;
		}
		
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
//	@GetMapping("add")
//	public String add(Model model) {
//		
//		model.addAttribute("product", new ProductDTO());
//		
//		return "admin/products/addEdit";
//	}
//	
//	@GetMapping("edit/{id}")
//	public String edit(Model model, @PathVariable("id") Long id) {
//		Optional<Product> opt = productService.findById(id);
//		ProductDTO dto = new ProductDTO();
//		
//		if(opt.isPresent()) {
//			Product entity = opt.get();
//			BeanUtils.copyProperties(entity, dto);
//			
//			model.addAttribute("product", dto);
//			
//			return "admin/products/addEdit";
//		}
//		
//		return "admin/product/addEdit";
//	}
//	
//	@PostMapping("saveUpdate")
//	public String saveUpdate(Model model,@Valid @ModelAttribute("product") ProductDTO dto, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return "";
//		}
//		Product entity = new Product();
//		BeanUtils.copyProperties(dto, entity);
//		Category category = new Category();
//		category.setCategory_id(dto.getCategory_id());
//		
//		entity.setCategory(category);
//
//		System.out.println(entity);
//		
//		productService.save(entity);
//		
//		return "redirect:/admin/products";
//	}
//	
//	@GetMapping("delete/{id}")
//	public String delete(@PathVariable("id") Long id) {
//		productService.deleteById(id);
//		return "redirect:/admin/products";
//	}
	 
	@PostMapping("/list")
	public List<ProductDTO> getAllProduct(@RequestBody AccountDTO account){
		 System.out.println(account);
		 List<ProductDTO> listdto = new ArrayList<>();
		if(account.getIsAdmin() == true) {
			List<Product> products = productService.findAll();
			for( int i = 0 ; i < products.size(); i++ ) {
				ProductDTO dto = new ProductDTO();
				BeanUtils.copyProperties(products.get(i), dto);
				dto.setCategory_id(products.get(i).getCategory().getCategory_id());
				listdto.add(dto);             
			}
			
			return listdto;
		}
		return null;
	}
	
	@GetMapping("/view/{id}")
	public ProductDTO getProductById(@PathVariable long id) {
		ProductDTO dto = new ProductDTO();
		Product entity = productService.getById(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
