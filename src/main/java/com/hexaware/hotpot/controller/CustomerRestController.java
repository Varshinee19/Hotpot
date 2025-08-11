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

import com.hexaware.hotpot.dto.CustomerDto;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.exception.CustomerNotFoundException;
import com.hexaware.hotpot.service.ICustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {
	@Autowired
	ICustomerService service;
	@PostMapping("/add")
	public Customer addCustomer(@RequestBody CustomerDto dto) {
		return service.addCustomer(dto);
		
	}
	@PutMapping("/update/{customerId}")
	public Customer updateCustomer(@PathVariable Integer customerId,@RequestBody CustomerDto dto) throws CustomerNotFoundException {
		return service.updateCustomer(customerId,dto);
	}
	@DeleteMapping("/delete/{customerId}")
	public String deleteCustomer(@PathVariable Integer customerId) {
		return service.deleteCustomerById(customerId);
	}
	@GetMapping("/getbyemail/{email}")
	public Customer getByEmail(@PathVariable String email) {
		return service.getCustomerByMail(email);
	}
	@GetMapping("/getbyid/{customerID}")
	public Customer getByEmail(@PathVariable Integer customerId) throws CustomerNotFoundException {
		return service.getById(customerId);
	}
	
	@GetMapping("/get")
	public List<Customer> getAll(){
		return service.getAllCustomer();
	}
	@GetMapping("/getorders/{customerId}")
	public List<Orders> getOrders(@PathVariable Integer customerId ){
		return service.getAllOrders(customerId);
	}
	
	

}
