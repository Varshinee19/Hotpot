package com.hexaware.hotpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.CartItemDto;
import com.hexaware.hotpot.entities.CartItems;
import com.hexaware.hotpot.exception.CartDoesNotExistException;
import com.hexaware.hotpot.exception.CartItemNotFoundException;
import com.hexaware.hotpot.service.ICartItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cartitem")
public class CartItemRestController {
	@Autowired
	ICartItemService service;
	@PostMapping("/add")
	public CartItems addItem(@Valid @RequestBody CartItemDto dto) throws CartDoesNotExistException {
		return service.addItem(dto);
	}
	@GetMapping("/get/{cartId}")
	public List<CartItems> getAll(@PathVariable Integer cartId) throws CartDoesNotExistException{
		return service.getItemsInCart(cartId);
	}
	@PutMapping("/update/{quantity}/{cartItemId}")
	public String update(@Valid @PathVariable Integer quantity,@PathVariable Integer cartItemId,@RequestBody CartItemDto dto) {
		service.updateItemQuantity(quantity,cartItemId);
		return "Updated successfully";
		
	}
	@GetMapping("/getbyid/{cartItemId}")
	public CartItems getById(@PathVariable Integer cartItemId) throws CartItemNotFoundException {
		return service.getById(cartItemId);
	}
	@DeleteMapping("/delete/{cartItemId}")
	public String delete(@PathVariable Integer cartItemId) throws CartItemNotFoundException {
		service.removeItem(cartItemId);
		return "Deleted successfully";
	}

}
