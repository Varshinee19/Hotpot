package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.CartItemDto;
import com.hexaware.hotpot.entities.CartItems;

public interface ICartItemService {
	public CartItems addItem(CartItemDto cartItem);
	public List<CartItems> getItemsInCart(int cartId);
	public String updateItemQuantity(int quantity,int cartItemId);
	public String removeItem(int cartItemId);
	public CartItems getById(int cartId);

}
