package com.hexaware.hotpot.service;
import java.util.List;

import com.hexaware.hotpot.dto.CustomerDto;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.exception.CustomerNotFoundException;

public interface ICustomerService {
	
	public Customer addCustomer(CustomerDto customer);
	public Customer updateCustomer(Integer customerId,CustomerDto customer) throws CustomerNotFoundException;
	public Customer getCustomerByMail(String email);
	public Customer getById(int customerId) throws CustomerNotFoundException;
	public String deleteCustomerById(Integer customerId);
	public List<Customer> getAllCustomer();
	public List<Orders> getAllOrders(int customerId);
	
	
	

}
