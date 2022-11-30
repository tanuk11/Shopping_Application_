package com.service;

import com.exception.LoginException;
import com.module.UserLogin;

public interface LoginService {


	public String logInAccount(UserLogin loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
