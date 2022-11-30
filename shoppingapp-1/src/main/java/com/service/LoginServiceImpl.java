package com.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.exception.LoginException;
import com.module.CurrentUserSession;
import com.module.UserLogin;
import com.module.Users;
import com.repository.CurrentUserSessionRepo;
import com.repository.LoginRepo;
import com.repository.UserRepo;


import net.bytebuddy.utility.RandomString;

public class LoginServiceImpl  implements LoginService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CurrentUserSessionRepo cusRepo;
	
	@Autowired
	private LoginRepo loginRepo;
	
	
	

	@Override
	public String logInAccount(UserLogin loginData) throws LoginException {
Optional<Users> opt = userRepo.findByEmail(loginData.getUserName());
		
		if(!opt.isPresent())
		{
			throw new LoginException("Invalid Login UserId");
		}
		
		Users newCustomer = opt.get();
		
		Integer customerId = newCustomer.getUserId();
		Optional<CurrentUserSession> currentUserOptional=cusRepo.findByUserId(customerId);
		
		if(currentUserOptional.isPresent()) {
			throw new LoginException("User Already login with this UserId");
		}
		
		if(newCustomer.getEmail().equals(loginData.getUserName()) && newCustomer.getPassword().equals(loginData.getPassword())) {
			String key = RandomString.make();
			
			CurrentUserSession currentUserSession = new CurrentUserSession(customerId, customerId, key, LocalDateTime.now());
		    cusRepo.save(currentUserSession);
		    
		   UserLogin logData = new UserLogin();
		    logData.setUserId(currentUserSession.getId());
		    logData.setUserName(loginData.getUserName());
		    logData.setPassword(loginData.getPassword());
		    loginRepo.save(logData);
		    
		    return currentUserSession.toString();
		}
		else
			throw new LoginException("Invalid UserName or Password!");
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {

		Optional<CurrentUserSession> currentUserOptional= cusRepo.findByUuid(key);
		
		if(!currentUserOptional.isPresent())
		{
			throw new LoginException("User has not logged in with this UserId");
		}
		
		CurrentUserSession currentUserSession =currentUserOptional.get();
		
		cusRepo.delete(currentUserSession);
		
		UserLogin logindata = loginRepo.findByUserId(currentUserSession.getId());

        loginRepo.delete(logindata);
		
        return "Logged Out......";
	}
}
