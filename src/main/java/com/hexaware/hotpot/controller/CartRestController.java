package com.hexaware.hotpot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.CartDto;
import com.hexaware.hotpot.entities.Cart;
import com.hexaware.hotpot.service.ICartService;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
	@Autowired
	ICartService service;
	@PostMapping("/add/{customerId")
	public Cart createCart(@PathVariable Integer customerId,@RequestBody CartDto dto) {
		return service.createCart(customerId);
	}
	@GetMapping("get/{cartId}")
	public Cart getCartById(@PathVariable Integer cartId){
		return service.getCartById(cartId);
	}
	@DeleteMapping("delete/{cartId}")
	public String deleteCart(@PathVariable Integer cartId) {
		service.clearCart(cartId);
		return "Cart deleted";
	}
	

}
