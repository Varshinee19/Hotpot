package com.hexaware.hotpot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotpot.dto.OrdersDto;
import com.hexaware.hotpot.entities.Orders;

class OrdersServiceImplTest {
	@Autowired
	RestTemplate rest;

	@Test
	void testAddOrder() {
		OrdersDto dto=new OrdersDto();
		dto.setTotalPrice(100.00);
		dto.setDeliveryAddress("A4 Ben Foundation Mogappier");
		dto.setStatus("Arriving");
		ResponseEntity<OrdersDto> response=rest.postForEntity("http//localhost:8080/api/orders/add", dto, OrdersDto.class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void testUpdateOrder() {
		OrdersDto dto=new OrdersDto();
		dto.setTotalPrice(150.00);
		dto.setDeliveryAddress("A4 Ben Foundation Mogappier");
		dto.setStatus("Arriving");
		ResponseEntity<OrdersDto> response=rest.postForEntity("http//localhost:8080/api/orders/update/1", dto, OrdersDto.class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void testGetByCustomer() {
		ResponseEntity<Orders> response=rest.getForEntity("http//localhost:8080/api/orders/getbycustomer/101", Orders.class);
		Assertions.assertNotNull(response.getBody());
	}
	@Test
	void testGetByRestaurant() {
		ResponseEntity<Orders> response=rest.getForEntity("http//localhost:8080/api/orders/getbyrestaurant/401", Orders.class);
		Assertions.assertNotNull(response.getBody());
	}
	void testUpdateStatus() {
		OrdersDto dto=new OrdersDto();
		dto.setOrderId(4);
		dto.setDeliveryAddress("delivered");
		ResponseEntity<Orders> response=rest.postForEntity("http//localhost:8080/api/orders/updatestatus/delivered/4",dto ,Orders.class);
		Assertions.assertEquals("delivered", response.getBody().getStatus());
		
	}
	@Test
	void testDelete() {
		rest.delete("http//localhost.8080/api/orders/delete/1");
	}
	@Test
	void testGetAll() {
		ResponseEntity<Orders[]>response=rest.getForEntity("\"http//localhost:8080/api/orders/get", Orders[].class);
		Assertions.assertTrue(response.getBody().length>0);
	}
	}


