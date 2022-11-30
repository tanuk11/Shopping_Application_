package com.service;

import com.exception.LoginException;
import com.module.CurrentUserSession;
import com.module.Users;

public interface CurrentUserSessionService{
	
	public CurrentUserSession getCurrentUserSession(String key) throws LoginException;
	public Integer getCurrentUserSessionId(String key) throws LoginException;
	
	public Users getCustomerDetails(String key);

}
