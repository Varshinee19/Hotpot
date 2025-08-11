package com.hexaware.hotpot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.CartItemDto;
import com.hexaware.hotpot.entities.Cart;
import com.hexaware.hotpot.entities.CartItems;
import com.hexaware.hotpot.entities.Menu;
import com.hexaware.hotpot.repository.CartItemsRepository;
import com.hexaware.hotpot.repository.CartRepository;
import com.hexaware.hotpot.repository.MenuRepository;

@Service
public class CartItemImpl implements ICartItemService {
    @Autowired
	CartItemsRepository repo;
    @Autowired
    CartRepository cartRepo;
    @Autowired
    MenuRepository menuRepo;
	@Override
	public CartItems addItem(CartItemDto cartItem) {
		Cart cart = cartRepo.findById(cartItem.getCartId()).orElse(null);
		Menu menu=menuRepo.findById(cartItem.getMenuId()).orElse(null);
		CartItems item=new CartItems();
	    
		item.setQuantity(cartItem.getQuantity());	
		item.setCart(cart);
		item.setMenu(menu);

		return repo.save(item);
		
	}

	@Override
	public List<CartItems> getItemsInCart(int cartid) {
		// TODO Auto-generated method stub
		return repo.findByCartId(cartid);
	}

	
	public String updateItemQuantity(int quantity,int cartitemid) {
		int updated=repo.updateQuantity(quantity, cartitemid);
		return updated > 0 ? "Updated successfully" : "Cart Item not found";
		
		
	}

	@Override
	public String removeItem(int cartitemid) {
		// TODO Auto-generated method stub
		repo.deleteById(cartitemid);
		return "Cart Item removed";
		
	}

	@Override
	public CartItems getById(int cartId) {
		// TODO Auto-generated method stub
		return repo.findById(cartId).orElse(null);
	}


}
