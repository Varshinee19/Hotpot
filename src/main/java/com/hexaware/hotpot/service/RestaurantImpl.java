package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.RestaurantDto;
import com.hexaware.hotpot.entities.Restaurant;
import com.hexaware.hotpot.repository.RestaurantRepository;
@Service
public class RestaurantImpl implements IRestaurantService {
	@Autowired
	RestaurantRepository repo;

	@Override
	public Restaurant addRestaurant(RestaurantDto dto) {
		Restaurant restaurant=readData(dto);
		return repo.save(restaurant);
		
	}

	@Override
	public Restaurant updateRestaurant(Integer restaurantId,RestaurantDto dto) {
		Optional<Restaurant>restaurant=repo.findById(restaurantId);
		Restaurant res=restaurant.get();
		res=readData(dto);
		return repo.save(res);
		
	}

	@Override
	public Restaurant getRestaurantByName(String restaurantName) {
		// TODO Auto-generated method stub
		return repo.findByName(restaurantName);
	}

	@Override
	public String deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		repo.deleteById(restaurantId);
		return "restaurant deleted successfully";
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	public Restaurant readData(RestaurantDto dto) {
		Restaurant restaurant=new Restaurant();
		restaurant.setRestaurantName(dto.getRestaurantName());
		restaurant.setRestaurantAddress(dto.getRestaurantAddress());
	    restaurant.setPhoneNo(dto.getPhoneNo());
		return restaurant;
		
	}

	@Override
	public Restaurant getById(int restaurantId) {
		// TODO Auto-generated method stub
		return repo.findById(restaurantId).orElse(null);
	}

}
