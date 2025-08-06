package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.entities.CartItems;

public interface ICartItemService {
	public CartItems addItem(CartItems cartItem);
	public List<CartItems> getItemsInCart(int cartid);
	public boolean updateItemQuantity(int cartitemid);
	public String removeItem(int cartitemid);

}
