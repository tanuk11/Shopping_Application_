package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.exception.LoginException;
import com.module.CurrentUserSession;
import com.module.Users;
import com.repository.CurrentUserSessionRepo;
import com.repository.UserRepo;



public class CurrentUserServiceImpl implements CurrentUserSessionService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CurrentUserSessionRepo cusRepo;
	
	

	@Override
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException {
          Optional<CurrentUserSession> currentUser = cusRepo.findByUuid(key);
		
		if(currentUser.isPresent()) {
			return currentUser.get();
		}
		else {
			throw new LoginException("UnAuthorized");
		}
	}

	@Override
	public Integer getCurrentUserSessionId(String key) throws LoginException {
		 Optional<CurrentUserSession> currentUser = cusRepo.findByUuid(key);
		 if(currentUser.isPresent()) {
				return currentUser.get().getId();
			}
			else {
				throw new LoginException("UnAuthorized");
			}
	}

	@Override
	public Users getCustomerDetails(String key) {
		 Optional<CurrentUserSession> currentUser = cusRepo.findByUuid(key);
		 if(currentUser.isPresent()) {
			Integer signUpUserId = 	currentUser.get().getUserId();
			 return (userRepo.findById(signUpUserId)).get();
			}
			else {
				return null;
			}
		 
		
	}
	
}
