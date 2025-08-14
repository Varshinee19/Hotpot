package com.hexaware.hotpot.controller;

import java.util.List;

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

import com.hexaware.hotpot.dto.RestaurantDto;
import com.hexaware.hotpot.entities.Restaurant;
import com.hexaware.hotpot.exception.RestaurantAlreadyExistsException;
import com.hexaware.hotpot.exception.RestaurantNotFoundException;
import com.hexaware.hotpot.service.IRestaurantService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantRestController{
	@Autowired
	IRestaurantService service;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/add")
	public Restaurant addRestaurant(@Valid @RequestBody RestaurantDto dto) throws RestaurantAlreadyExistsException {
		return service.addRestaurant(dto);
	}
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/update/{restaurantId}")
	public Restaurant updateRestaurant(@Valid @PathVariable Integer restaurantId,@RequestBody RestaurantDto dto) throws RestaurantNotFoundException {
		return service.updateRestaurant(restaurantId,dto);
		
	}
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{restaurantId}")
	public String getByRestaurant(@PathVariable Integer restaurantId) throws RestaurantNotFoundException {
		service.deleteRestaurant(restaurantId);
		return "Record Deleted successfully";
	}
	@PreAuthorize("hasRole('ADMIN')or hasRole('CUSTOMER')")
	@GetMapping("/get")
	public List<Restaurant> getAll(){
		return service.getAllRestaurant();
	}
	@PreAuthorize("hasRole('ADMIN')or hasRole('CUSTOMER')")
	@GetMapping("/getbyid/{restaurantId}")
	public Restaurant getById(@PathVariable Integer restaurantId) throws RestaurantNotFoundException{
		return service.getById(restaurantId);
	}
	
	
	
	
	
	
	

}
