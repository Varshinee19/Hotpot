package com.hexaware.hotpot.service;

import java.util.List;

import com.hexaware.hotpot.dto.OrderItemsDto;
import com.hexaware.hotpot.entities.OrderItems;
import com.hexaware.hotpot.exception.OrderItemNotAvailableException;
import com.hexaware.hotpot.exception.OrderNotExistException;

public interface IOrderItemService {
	public OrderItems addItem(OrderItemsDto orderItem);
	public List<OrderItems> getItemsByOrder(int orderId) throws OrderNotExistException;
	public OrderItems updateItem(Integer orderItemId,OrderItemsDto orderItem) throws OrderItemNotAvailableException;
	public OrderItems getById(int orderItemId)throws OrderItemNotAvailableException;
	public String removeItem(int orderItemId)throws OrderItemNotAvailableException;

}
