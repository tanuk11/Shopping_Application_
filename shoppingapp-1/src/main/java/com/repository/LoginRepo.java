package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.UserLogin;

public interface LoginRepo extends JpaRepository<UserLogin,Integer> {
	public UserLogin findByUserId(Integer userId);
}
