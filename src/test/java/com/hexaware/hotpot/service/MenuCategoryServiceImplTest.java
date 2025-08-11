package com.hexaware.hotpot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotpot.dto.MenuCategoriesDto;
import com.hexaware.hotpot.entities.MenuCategories;

class MenuCategoryServiceImplTest {
	@Autowired
	RestTemplate rest;

	@Test
	void testAddCategory() {
		MenuCategoriesDto dto=new MenuCategoriesDto();
		dto.setCategoryName("Brunch");
		ResponseEntity<MenuCategoriesDto>response=rest.postForEntity("http//localhost:8080/api/menucategory/add", dto, MenuCategoriesDto.class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void updateAddCategory() {
		MenuCategoriesDto dto=new MenuCategoriesDto();
		dto.setCategoryName("Late Brunch");
		rest.postForEntity("http//localhost:8080/api/menucategory/update/4", dto, MenuCategoriesDto.class);
		ResponseEntity<MenuCategoriesDto>response=rest.getForEntity("http//localhost:8080/api/menucategory/getbyid/4", MenuCategoriesDto.class);
		Assertions.assertEquals("Late Brunch",response.getBody().getCategoryName());	
		
	}
	@Test
	void testGetAll() {
		ResponseEntity<MenuCategories[]>response=rest.getForEntity("http//localhost:8080/api/menucategory/get", MenuCategories[].class);
		Assertions.assertTrue(response.getBody().length>1);
		
	}
	void testDelete() {
		rest.delete("http//localhost:8080/api/menucategory/delete/4");
		ResponseEntity<MenuCategories[]>response=rest.getForEntity("http//localhost:8080/api/menucategory/get", MenuCategories[].class);
		Assertions.assertNull(response.getBody());
		
		
		
	}
	
	

}
