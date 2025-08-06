package com.hexaware.hotpot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexaware.hotpot.entities.Orders;
@Service
public class OrderImpl implements IOrderService {

	@Override
	public Orders placeOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders updateOrder(Orders order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getOrdersByCustomer(int custid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> getOrdersByRestaurant(int resid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders updateOrderStatus(int orderid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancelOrder(int orderid) {
		// TODO Auto-generated method stub
		return null;
	}

}
