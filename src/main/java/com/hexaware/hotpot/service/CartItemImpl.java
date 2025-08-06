package com.hexaware.hotpot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.CartItems;

@Service
public class CartItemImpl implements ICartItemService {

	@Override
	public CartItems addItem(CartItems cartItem) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CartItems> getItemsInCart(int cartid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateItemQuantity(int cartitemid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String removeItem(int cartitemid) {
		// TODO Auto-generated method stub
		return null;
	}

}
