package com.hexaware.hotpot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.Cart;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.repository.CartRepository;
import com.hexaware.hotpot.repository.CustomerRepository;
@Service
public class CartImpl implements ICartService {
	
	@Autowired
	CartRepository repo;
	
	@Autowired
	CustomerRepository customerRepo;

	@Override
	public Cart createCart(int customerId) {
		// TODO Auto-generated method stub
		Customer customer=customerRepo.findById(customerId).orElse(null);
		Cart cart=new Cart();
		cart.setCustomer(customer);
		return repo.save(cart);
	}

	@Override
	public Cart getCartById(int cartId) {
		// TODO Auto-generated method stub
		return repo.findById(cartId).orElse(null);
	}

	@Override
	public String clearCart(int cartid) {
		// TODO Auto-generated method stub
		repo.deleteById(cartid);
		return "Cart deleted";
	}

}
