package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.RestaurantDto;
import com.hexaware.hotpot.entities.Restaurant;

public interface IRestaurantService {
	
	public Restaurant addRestaurant(RestaurantDto dto);
	public Restaurant updateRestaurant(Integer restaurantId,RestaurantDto dto);
	public Restaurant getRestaurantByName(String restaurantName);
	public Restaurant getById(int restaurantId);
	public String deleteRestaurant(int resaurantId);
	List<Restaurant> getAllRestaurant();

}
