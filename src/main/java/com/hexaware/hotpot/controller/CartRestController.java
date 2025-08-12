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
import com.hexaware.hotpot.exception.CartAlreadyExistsException;
import com.hexaware.hotpot.exception.CartDoesNotExistException;
import com.hexaware.hotpot.exception.CustomerNotFoundException;
import com.hexaware.hotpot.service.ICartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
	@Autowired
	ICartService service;
	@PostMapping("/add/{customerId}")
	public Cart createCart(@Valid @PathVariable Integer customerId,@RequestBody CartDto dto) throws CartAlreadyExistsException, CustomerNotFoundException {
		return service.createCart(customerId);
	}
	@GetMapping("get/{cartId}")
	public Cart getCartById(@PathVariable Integer cartId) throws CartDoesNotExistException{
		return service.getCartById(cartId);
	}
	@DeleteMapping("delete/{cartId}")
	public String deleteCart(@PathVariable Integer cartId) throws CartDoesNotExistException {
		service.clearCart(cartId);
		return "Cart deleted";
	}
	

}
