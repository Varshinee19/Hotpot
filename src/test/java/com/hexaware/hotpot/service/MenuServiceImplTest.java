package com.hexaware.hotpot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotpot.dto.MenuDto;
import com.hexaware.hotpot.entities.Menu;

class MenuServiceImplTest {

	@Autowired
	RestTemplate rest;
	@Test
	void testAdd() {
		MenuDto dto=new MenuDto();
		dto.setItemName("Panner");
		dto.setType("Veg");
		dto.setDescription("Creamy vegiterian gravy");
		dto.setImage("url");
		dto.setPrice(250);
		ResponseEntity<MenuDto>response=rest.postForEntity("http//localhost:8080/api/menu/add", dto, MenuDto.class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void testGetByRestaurant() {
		ResponseEntity<Menu[]>response=rest.getForEntity("http//localhost:8080/api/menu/getbyrestaurant/401", Menu[].class);
		Assertions.assertNotNull(response.getBody());
		
	}
	@Test
	void testGetByCategory() {
		ResponseEntity<Menu[]>response=rest.getForEntity("http//localhost:8080/api/menu/getbycategory/1", Menu[].class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void deleteMenu() {
		rest.delete("http//localhost:8080/api/menu/delete/1");
		ResponseEntity<Menu>response=rest.getForEntity("http//localhost:8080/api/menu/getbyid/1", Menu.class);
		Assertions.assertNull(response.getBody());
		
	}

}
