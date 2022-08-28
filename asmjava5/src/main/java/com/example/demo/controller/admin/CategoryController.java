package com.example.demo.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;
import com.example.demo.dto.AccountDTO;
import com.example.demo.dto.CategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.CategoryService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/admin/categories/")
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/list")
	public List<CategoryDTO> getAllProduct(@RequestBody AccountDTO account){
		 System.out.println(account);
		 List<CategoryDTO> listdto = new ArrayList<>();
		if(account.getIsAdmin() == true) {
			List<Category> categories = categoryService.findAll();
			for( int i = 0 ; i < categories.size(); i++ ) {
				CategoryDTO dto = new CategoryDTO();
				BeanUtils.copyProperties(categories.get(i), dto);
				listdto.add(dto);             
			}
			return listdto;
		}
		return null;
	}
	
	@PostMapping("/delete/{id}")
	public Boolean deleteProducts(@PathVariable long id, @RequestBody AccountDTO dto) {
		if(dto.getIsAdmin() == true) {
			categoryService.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}
	
	@PostMapping("/save/{isAdmin}")
	public Boolean createProduct(@RequestBody CategoryDTO dto,@PathVariable Long isAdmin) {
		if(isAdmin == 1) {
			Category category = new Category();
			BeanUtils.copyProperties(dto, category);
			categoryService.save(category);
			return true;
		} else {
			return false;
		}
	}
	
	@GetMapping("/view/{id}")
	public CategoryDTO getById(@PathVariable long id) {
		CategoryDTO dto = new CategoryDTO();
		Category entity = categoryService.getById(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
	
//	@GetMapping("add")
//	public String add(Model model) {
//		
//		model.addAttribute("category", new CategoryDTO());
//		return "admin/categories/addEdit";
//	}
//	
//	@GetMapping("edit/{category_id}")
//	public String edit(Model model, @PathVariable("category_id") Long id) {
//		Optional<Category> opt = categoryService.findById(id);
//		CategoryDTO dto = new CategoryDTO();
//		
//		if(opt.isPresent()) {
//			Category entity = opt.get();
//			BeanUtils.copyProperties(entity, dto);
//			
//			model.addAttribute("category", dto);
//			
//			return "admin/categories/addEdit";
//		}
//		
//		return "redirect:/admin/categories";
//	}
//	
//	@GetMapping("delete/{category_id}")
//	public String delete(@PathVariable("category_id") Long id) {
//		categoryService.deleteById(id);
//		
//		return "redirect:/admin/categories";
//	}
//	
//	@PostMapping("saveUpdate")
//	public String saveUpdate(Model model, CategoryDTO dto) {
//		if(dto.getName().isEmpty()) {
//			model.addAttribute("message", "phai nhap du cac o");
//			model.addAttribute("category", new CategoryDTO());
//			return "admin/categories/addEdit";
//		}
//		
//		Category entity = new Category();
//		BeanUtils.copyProperties(dto, entity);
//		
//		categoryService.save(entity);
//		
//		model.addAttribute("message", "cateory is saved");
//		
//		return "redirect:/admin/categories";
//	}
//	
//	@GetMapping("")
//	public String list(ModelMap model, @RequestParam("p") Optional<Integer> p) {
//		Pageable pageable = PageRequest.of(p.orElse(0), 5);
//		Page<Category> page = categoryService.findAll(pageable);
//		List<Category> list = categoryService.findAll();
//		
//		model.addAttribute("categories",page);
//		return "admin/categories/list";
//	}
//	
//	public String search() {
//		return "admin/categories/search";
//	}
}
