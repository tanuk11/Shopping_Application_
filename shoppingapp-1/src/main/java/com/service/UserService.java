package com.service;

import java.util.List;

import com.exception.UserException;
import com.module.Users;


public interface UserService {

   public Users addCustomer(Users user) throws UserException;
	
	public  Users updateCustomer(Users user) throws  UserException;
	
	public Users removeCustomer(String email) throws  UserException;
	
	public Users viewCustomer(String email) throws  UserException;
	
	public List<Users> viewAllCustomer() throws  UserException;
	
}
