package com.hexaware.hotpot.service;

import com.hexaware.hotpot.entities.Cart;

public interface ICartService {
	public Cart createCart(int custid);
	public Cart getCartById(int cartId);
	public String clearCart(int cartid);

}
