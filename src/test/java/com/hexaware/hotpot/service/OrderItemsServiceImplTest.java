package com.hexaware.hotpot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotpot.dto.OrderItemsDto;
import com.hexaware.hotpot.entities.OrderItems;

class OrderItemsServiceImplTest {
	@Autowired
	RestTemplate rest;

	@Test
	void testAddItem() {
		OrderItemsDto dto=new OrderItemsDto();
		dto.setItemName("Pizza");
		dto.setQuantity(2);
		dto.setPrice(250);
		dto.setMenuId(5);
		ResponseEntity<OrderItems>response=rest.postForEntity("http://localhost:8080/api/orders/add",dto,OrderItems.class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void testUpdateItem() {
		OrderItemsDto dto=new OrderItemsDto();	
		dto.setItemName("Cheese Pizza");
		dto.setQuantity(2);
		dto.setPrice(290);
		dto.setMenuId(5);
		rest.postForEntity("http://localhost:8080/api/orders/update/3",dto,OrderItems.class);
		ResponseEntity<OrderItems>response=rest.getForEntity("http://localhost:8080/api/orders/getbyid/3",OrderItems.class);
		Assertions.assertEquals("Cheese Pizza", response.getBody().getItemName());
		
	}
	@Test
	void testGetAll() {
		ResponseEntity<OrderItems[]>response=rest.getForEntity("http://localhost:8080/api/orders/get",OrderItems[].class);
		Assertions.assertTrue(response.getBody().length>1);
	}
	@Test
	void testGetById() {
		ResponseEntity<OrderItems>response=rest.getForEntity("http://localhost:8080/api/orders/getbyid/3",OrderItems.class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void testdelete() {
		rest.delete("http://localhost:8080/api/orders/delete/3");
		ResponseEntity<OrderItems>response=rest.getForEntity("http://localhost:8080/api/orders/getbyid/3",OrderItems.class);
		Assertions.assertNull(response.getBody());
	}

}
