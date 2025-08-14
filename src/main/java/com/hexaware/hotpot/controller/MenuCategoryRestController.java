package com.hexaware.hotpot.controller;
/*
 * 
 * auth: Varshinee
 * controller class .
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.MenuCategoriesDto;
import com.hexaware.hotpot.entities.MenuCategories;
import com.hexaware.hotpot.exception.CategoryDoesNotExistException;
import com.hexaware.hotpot.service.IMenuCategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/menucategory")
public class MenuCategoryRestController {
	private static final Logger log = LoggerFactory.getLogger(CustomerRestController.class);
	@Autowired
	IMenuCategoryService service;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add")
	public MenuCategories addCategory(@Valid @RequestBody MenuCategoriesDto dto) {
		log.info("A new category has been created");
		return service.addCategory(dto);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{categoryId}")
	public MenuCategories updateCategory(@Valid @PathVariable Integer categoryId,MenuCategoriesDto dto) throws CategoryDoesNotExistException {
		return service.updateCategory(categoryId,dto);
		
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@GetMapping("/get")
	public List<MenuCategories> getAll(){
		return service.getAllCategories();
	}
	@PreAuthorize("hasRole('ADMIN') or hasRole('CUSTOMER')")
	@GetMapping("/getbyid/{categoryId}")
	public MenuCategories getById(@PathVariable Integer categoryId) throws CategoryDoesNotExistException{
		return service.getById(categoryId);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{categoryId}")
	public String deleteCategory(@PathVariable Integer categoryId) throws CategoryDoesNotExistException {
		service.deleteCategory(categoryId);
		return "Category deleted successfully";
	}
	

}
