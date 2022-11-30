package com.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.CurrentUserSession;
import com.service.CurrentUserSessionService;

public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession,Integer>{

public Optional<CurrentUserSession> findByUserId(Integer userId);
	
	public Optional<CurrentUserSession> findByUuid(String uuid);
}
