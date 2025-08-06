package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.Restaurant;

public interface IRestaurantService {
	
	public Restaurant addRestaurant(Restaurant restaurant);
	public Restaurant updateRestaurant(Restaurant restaurant);
	public Restaurant getRestaurantByName(String rname);
	public String deleteRestaurant(int resid);
	List<Restaurant> getAllRestaurant();

}
