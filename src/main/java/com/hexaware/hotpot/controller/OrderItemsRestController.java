package com.hexaware.hotpot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hotpot.dto.OrderItemsDto;

import com.hexaware.hotpot.entities.OrderItems;
import com.hexaware.hotpot.service.IOrderItemService;

@RestController
@RequestMapping("/api/orderitems")
public class OrderItemsRestController {
	@Autowired
	IOrderItemService service;
	@PostMapping("/add")
	public OrderItems addOrderItem(@RequestBody OrderItemsDto dto) {
		return service.addItem(dto);
	}
	@GetMapping("/getbyorder/{orderId}")
	public List<OrderItems> getByOrder(@PathVariable Integer orderId){
		return service.getItemsByOrder(orderId);
	}
	@PutMapping("/update/{orderItemId}")
	public OrderItems updateOrder(@PathVariable Integer orderItemId,@RequestBody OrderItemsDto dto) {
		return service.updateItem(orderItemId,dto);
	}
	@GetMapping("/getbyid/{orderItemId}")
	public OrderItems getById(@PathVariable Integer orderItemId){
		return service.getById(orderItemId);
	}
	@DeleteMapping("/delete/{orderItemId}")
	public String deleteItem(@PathVariable Integer orderItemId) {
		service.removeItem(orderItemId);
		return "Item removed successfully";
	}
	

}
