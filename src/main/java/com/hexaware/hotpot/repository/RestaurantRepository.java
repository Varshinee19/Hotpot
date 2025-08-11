package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.entities.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer>{
	
	public Restaurant findByName(String rname);
}


