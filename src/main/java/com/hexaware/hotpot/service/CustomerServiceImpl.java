package com.hexaware.hotpot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.hotpot.dto.CustomerDto;
import com.hexaware.hotpot.entities.Customer;
import com.hexaware.hotpot.entities.Orders;
import com.hexaware.hotpot.exception.CustomerNotFoundException;
import com.hexaware.hotpot.repository.CustomerRepository;
import com.hexaware.hotpot.repository.OrdersRepository;
@Service
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	CustomerRepository repo;
	@Autowired
	OrdersRepository orderRepo;
	@Override
	public Customer addCustomer(CustomerDto customer) {
		Customer cust=readData(customer);
		return repo.save(cust);
		
	}
	
	public Customer updateCustomer(Integer customerId,CustomerDto customer) throws CustomerNotFoundException {
		Optional<Customer> optionalCust=repo.findById(customerId);
		Customer cust=optionalCust.get();
		cust=readData(customer);
		return repo.save(cust);
		
	}


	@Override
	public String deleteCustomerById(Integer custid) {
		
		repo.deleteById(custid);
		return "Record deleted successfully";
	}

	
	public Customer getCustomerByMail(String email) {
		
		return repo.findByEmail(email);
	}
	@Override
	public Customer getById(int customerId) throws CustomerNotFoundException {
		
		return repo.findById(customerId).orElseThrow(()->new CustomerNotFoundException("Not Found"));
	}


	
	
	public List<Customer> getAllCustomer() {
		
		return repo.findAll();
	}

	
	public List<Orders> getAllOrders(int customerId) {
		
		return orderRepo.findByCustomer(customerId);
	}
	public Customer readData(CustomerDto customer) {
		Customer cust=new Customer();
		cust.setName(customer.getName());
		cust.setEmail(customer.getEmail());
		cust.setAddress(customer.getAddress());
		cust.setPhone(customer.getPhone());
		cust.setRole(customer.getRole());
		return cust;
	}




}
