package com.hexaware.hotpot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.OrderItemsDto;
import com.hexaware.hotpot.entities.Menu;
import com.hexaware.hotpot.entities.OrderItems;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.exception.OrderItemNotAvailableException;
import com.hexaware.hotpot.exception.OrderNotExistException;
import com.hexaware.hotpot.repository.MenuRepository;
import com.hexaware.hotpot.repository.OrderItemsRepository;
import com.hexaware.hotpot.repository.OrdersRepository;
@Service
public class OrderItemImpl implements IOrderItemService{
	@Autowired
	OrderItemsRepository repo;
	@Autowired
	OrdersRepository orderRepo;
	@Autowired
	MenuRepository menuRepo;

	public OrderItems addItem(OrderItemsDto orderItem) {
		// TODO Auto-generated method stub
		Orders order=orderRepo.findById(orderItem.getOrderId()).orElse(null);
		Menu menu=menuRepo.findById(orderItem.getMenuId()).orElse(null);
		OrderItems item=new OrderItems();
		item.setItemName(orderItem.getItemName());
		item.setQuantity(orderItem.getQuantity());
		item.setPrice(orderItem.getPrice());
		item.setOrder(order);
		item.setMenu(menu);
		return repo.save(item);
	}

	@Override
	public List<OrderItems> getItemsByOrder(int orderId)throws OrderNotExistException {
	orderRepo.findById(orderId).orElseThrow(()->new OrderNotExistException());

		return repo.findByOrderOrderId(orderId);
	}

	@Override
	public OrderItems updateItem(Integer OrderItemId,OrderItemsDto orderItem)throws OrderItemNotAvailableException {
		OrderItems order=repo.findById(OrderItemId).orElseThrow(()->new OrderItemNotAvailableException());
		order.setItemName(orderItem.getItemName());
	    order.setQuantity(orderItem.getQuantity());
	    order.setPrice(orderItem.getPrice());
	    return repo.save(order);
	    
	}
	@Override
	public OrderItems getById(int orderItemId) throws OrderItemNotAvailableException {
		
		return repo.findById(orderItemId).orElseThrow(()->new OrderItemNotAvailableException());
	}


	@Override
	public String removeItem(int orderItemId) throws OrderItemNotAvailableException {
		repo.findById(orderItemId).orElseThrow(()->new OrderItemNotAvailableException());
		repo.deleteById(orderItemId);
		return "deleted successfully";
	}



}
