package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.entities.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	@Query("Select c from customer c where c.email=?1")
	public Customer getByEmail(String email);

}
