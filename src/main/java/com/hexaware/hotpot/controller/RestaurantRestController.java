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

import com.hexaware.hotpot.dto.RestaurantDto;
import com.hexaware.hotpot.entities.Restaurant;
import com.hexaware.hotpot.service.IRestaurantService;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantRestController{
	@Autowired
	IRestaurantService service;
	@PostMapping("/add")
	public Restaurant addRestaurant(@RequestBody RestaurantDto dto) {
		return service.addRestaurant(dto);
	}
	@PutMapping("/update/{restaurantId}")
	public Restaurant updateRestaurant(@PathVariable Integer restaurantId,@RequestBody RestaurantDto dto) {
		return service.updateRestaurant(restaurantId,dto);
		
	}
	@DeleteMapping("/delete/{restaurantId}")
	public String getByRestaurant(@PathVariable Integer restaurantId) {
		service.deleteRestaurant(restaurantId);
		return "Record Deleted successfully";
	}
	@GetMapping("/get")
	public List<Restaurant> getAll(){
		return service.getAllRestaurant();
	}
	@GetMapping("/getbyid/{restaurantId}")
	public Restaurant getById(@PathVariable Integer restaurantId){
		return service.getById(restaurantId);
	}
	
	
	
	
	
	
	

}
