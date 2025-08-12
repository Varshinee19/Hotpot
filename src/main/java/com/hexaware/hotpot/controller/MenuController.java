package com.hexaware.hotpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.MenuDto;
import com.hexaware.hotpot.entities.Menu;
import com.hexaware.hotpot.exception.CategoryDoesNotExistException;
import com.hexaware.hotpot.exception.MenuNotFoundException;
import com.hexaware.hotpot.exception.RestaurantNotFoundException;
import com.hexaware.hotpot.service.IMenuService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
	@Autowired
	IMenuService service;
	
	@PostMapping("/add")
	public Menu addMenu(@Valid @RequestBody MenuDto dto) throws RestaurantNotFoundException, CategoryDoesNotExistException {
		return service.addMenuItem(dto);
	}
	@PutMapping("/update/{menuId}")
	public Menu updateMenu(@Valid @PathVariable Integer menuId,MenuDto dto) throws MenuNotFoundException {
		return service.updateMenu(menuId,dto);
	}
	@GetMapping("/getbyrest/{restaurantId}")
	public List<Menu> getByRestaurant(@PathVariable Integer restaurantId) throws RestaurantNotFoundException{
		return service.getMenuByRestaurant(restaurantId);
	}
	@GetMapping("/getbycategory/{categoryId}")
	public List<Menu> getByRestaurant(@PathVariable int categoryId) throws RestaurantNotFoundException{
		return service.getMenuByRestaurant(categoryId);
	}
	@DeleteMapping("/delete/{menuId}")
	public String deleteMenu(@PathVariable Integer menuId) throws MenuNotFoundException {
		return service.deleteMenuItem(menuId);
	}
	@GetMapping("/getall")
	public List<Menu> getAll(){
		return service.getAllMenu();
	}
	@GetMapping("/getbyid/{menuId}")
	public Menu getById(@PathVariable Integer menuId)throws MenuNotFoundException{
		return service.getById(menuId);
	}
	

}
