package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.Cart;

public interface CartRepo extends JpaRepository<Cart ,Integer> {

}
