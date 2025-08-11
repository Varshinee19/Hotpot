package com.hexaware.hotpot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.hotpot.dto.CartItemDto;

class CartItemServiceImplTest {
	
	@Autowired
	RestTemplate rest;

	@Test
	void testAddCartItem() {
		CartItemDto dto=new CartItemDto();
		dto.setCartId(2);
		dto.setMenuId(4);
		dto.setQuantity(5);
		dto.setOrderItemId(4);
		ResponseEntity<CartItemDto>response=rest.postForEntity("http//localhost:8080/api/cartitem/add", dto,CartItemDto.class);
		Assertions.assertNotNull(response.getBody());	
	}
	@Test
	void testUpdateCartItem() {
		CartItemDto dto=new CartItemDto();
		int cartItemId=1;
		dto.setCartId(2);
		dto.setMenuId(4);
		dto.setQuantity(6);
		dto.setOrderItemId(4);
		ResponseEntity<CartItemDto>response=rest.postForEntity("http//localhost:8080/api/cartitem/update/"+cartItemId, dto,CartItemDto.class);
		Assertions.assertEquals(6,response.getBody().getQuantity());
		
	}
	@Test
	void testGetAll() {
		ResponseEntity<CartItemDto[]>response=rest.getForEntity("http//localhost:8080/api/cartitem/get",CartItemDto[].class);
		Assertions.assertTrue(response.getBody().length>1);
	}
	@Test
	void testGetById() {
		ResponseEntity<CartItemDto>response=rest.getForEntity("http//localhost:8080/api/cartitem/getbyid/1",CartItemDto.class);
		Assertions.assertNotNull(response.getBody());
		
	}
	@Test
	void testDelete() {
		rest.delete("http//localhost:8080/api/cartitem/delete/1");
		ResponseEntity<CartItemDto>response=rest.getForEntity("http//localhost:8080/api/cartitem/getbyid/1",CartItemDto.class);
		Assertions.assertNull(response.getBody());
		
	}
	
	
	

}
