package com.hexaware.hotpot.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotpot.dto.RestaurantDto;
import com.hexaware.hotpot.entities.Restaurant;

class RestaurantServiceImplTest {
	@Autowired
	RestTemplate rest;


	@Test
	void addRestaurant() {
		RestaurantDto dto=new RestaurantDto();
		dto.setRestaurantName("Bhavyam");
		dto.setPhoneNo("78693032132");
		dto.setRestaurantAddress("Kotturpuram Main Road 2nd cross street");
		ResponseEntity<RestaurantDto> response=rest.postForEntity("http://localhost:8080/api/restaurant/add", dto, RestaurantDto.class);
		RestaurantDto restaurant=response.getBody();
		Assertions.assertNotNull(restaurant);
		
	}
	@Test
	void updateRestaurant() {
		RestaurantDto dto=new RestaurantDto();
		dto.setRestaurantName("bhavyam hotel");
		dto.setPhoneNo("78693032132");
		dto.setRestaurantAddress("Kotturpuram Main Road 2nd cross street");
		rest.put("http://localhost:8080/api/restaurant/update/1,",dto);
		ResponseEntity<RestaurantDto>response=rest.getForEntity("http://localhost:8080/api/restaurant/getbyid/1", RestaurantDto.class);
		Assertions.assertEquals("bhavyam hotel",response.getBody().getRestaurantName());
	}
	@Test
	void getRestaurant() {
		ResponseEntity<Restaurant[]>response=rest.getForEntity("http://localhost:8080/api/restaurant/get", Restaurant[].class);
		Assertions.assertTrue(response.getBody().length>0);
	}
	@Test
	void testgetbyid() {
		ResponseEntity<Restaurant[]>response=rest.getForEntity("http://localhost:8080/api/restaurant/get/4", Restaurant[].class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void deleteRestaurant() {
	rest.delete("http://localhost:8080/api/restaurant/delete/1");
	ResponseEntity<RestaurantDto>response=rest.getForEntity("http://localhost:8080/api/restaurant/getbyid/1", RestaurantDto.class);
	Assertions.assertNull(response.getBody());
	
	}

}
