package com.hexaware.hotpot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hexaware.hotpot.entities.OrderItems;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems,Integer>{

}
