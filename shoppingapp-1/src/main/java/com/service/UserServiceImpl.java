package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.UserException;
import com.module.Users;
import com.repository.UserRepo;




@Service
public class UserServiceImpl implements UserService {
    @Autowired
	private UserRepo userRepo;
	
	@Override
	public Users addCustomer(Users user) throws UserException {
      Optional<Users> opt = userRepo.findByEmail(user.getEmail());
		
		if(opt.isPresent()) {
			throw new UserException("Customer already exist with this email id");
		}
		Users addedUser =userRepo.save(user);
		
		return addedUser;
	}

	@Override
	public Users updateCustomer(Users user) throws UserException {
     Optional<Users> opt = userRepo.findById(user.getUserId());
		
		if(opt.isPresent()) {
	  Users updatedUser = userRepo.save(user);
			
			return updatedUser;
			
		}
		else {
			throw new UserException("No customer exist with this id");
		}
	}

	@Override
	public Users removeCustomer(String email) throws UserException {
		 Optional<Users> opt = userRepo.findByEmail(email);
			if(opt.isPresent()) {
		  Users removeCustomer = opt.get();
		  userRepo.delete(removeCustomer);
				
				return removeCustomer;
				
			}
			else {
				throw new UserException("No customer exist with this email");
			}
	}

	@Override
	public Users viewCustomer(String email) throws UserException {
		 Optional<Users> opt = userRepo.findByEmail(email);
			if(opt.isPresent()) {
		  Users viewCustomer = opt.get();
	
				
				return viewCustomer;
				
			}
			else {
				throw new UserException("No customer exist with this email");
			}
	}

	@Override
	public List<Users> viewAllCustomer() throws UserException {
		List<Users> lists =userRepo.findAll();
		
		if(lists.size()==0) {
			throw new UserException("User list is empty..");
		}
		return lists;
				
	}

	
}
