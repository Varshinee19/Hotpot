package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.OrdersDto;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.repository.OrdersRepository;
@Service
public class OrderImpl implements IOrderService {
	@Autowired
	OrdersRepository repo;

	@Override
	public Orders placeOrder(OrdersDto dto) {
		// TODO Auto-generated method stub
		Orders order=readData(dto);
		return repo.save(order);
	}

	@Override
	public Orders updateOrder(Integer orderId,OrdersDto dto) {
		// TODO Auto-generated method stub
	
	    Optional<Orders> findOrder=repo.findById(orderId);
	    Orders ord=findOrder.get();
	    ord.setTotalPrice(dto.getTotalPrice());
	    ord.setDeliveryAddress(dto.getDeliveryAddress());
	    ord.setStatus(dto.getStatus());
	    return repo.save(ord);
	}

	@Override
	public List<Orders> getOrdersByCustomer(int customerId) {
		// TODO Auto-generated method stub
		return repo.findByCustomer(customerId);
	}

	@Override
	public List<Orders> getOrdersByRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		return repo.findByRestaurant(restaurantId);
	}

	@Override
	public Orders updateOrderStatus(String status,int orderId) {
		// TODO Auto-generated method stub
		return repo.updateOrderStatus(status, orderId);
	}

	@Override
	public String cancelOrder(int orderId) {
		
		repo.deleteById(orderId);
		return "Order cancelled";
	}
	@Override
	public List<Orders> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	public Orders readData(OrdersDto dto) {
		Orders order=new Orders();
		order.setTotalPrice(dto.getTotalPrice());
		order.setDeliveryAddress(dto.getDeliveryAddress());
		order.setStatus(dto.getStatus());
		return order;
		
		
	}

	@Override
	public Orders getById(int orderId) {
		// TODO Auto-generated method stub
		return repo.findById(orderId).orElse(null);
	}



}
