package com.hexaware.hotpot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.hotpot.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>{
	
	public List<Orders> findByCustomer(int custid);
	public List<Orders> findByRestaurant(int resid);
	@Modifying
	@Transactional
	@Query(value="Update o set o.status=?:1 from Orders o where orderId=?:2")
	public Orders updateOrderStatus(String status,int orderId);
	


}
