package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.Order;

public interface OrderRepo extends JpaRepository<Order,Integer>{

}
