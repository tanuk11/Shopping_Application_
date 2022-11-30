package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.module.Users;

@Repository
public interface UserRepo extends JpaRepository<Users,Integer> {

	public Optional<Users> findByEmail(String email);
}
