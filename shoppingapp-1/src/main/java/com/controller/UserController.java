package com.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exception.UserException;
import com.module.Users;
import com.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/adduser")
	public ResponseEntity<Users> addCustomer( @RequestBody Users user) throws UserException{
		
		Users newUser = userService.addCustomer(user);
		
		
		return new ResponseEntity<>(newUser, HttpStatus.ACCEPTED);
	}
	
    @PutMapping("/updateuser")
	public ResponseEntity<Users> updateCustomer(@RequestBody Users user) throws UserException{
		
	 Users updateduser = userService.updateCustomer(user);
		
		
		return new ResponseEntity<>(updateduser, HttpStatus.ACCEPTED);
	}
    
    
    @DeleteMapping("/deleteuser/{email}")
    public ResponseEntity<Users> deleteCustomer(@PathVariable("email") String email) throws UserException{
		
		Users deleteuser = userService.removeCustomer(email);
		
		
		return new ResponseEntity<>(deleteuser, HttpStatus.OK);
	}
	
    
    @GetMapping("/viewuser/{email}")
    public ResponseEntity<Users> viewCustomer(@PathVariable("email") String email) throws UserException{
		
		Users viewuser = userService.viewCustomer(email);
		
		
		return new ResponseEntity<>(viewuser, HttpStatus.OK);
	}
    
	@GetMapping("/listofusers")
     public ResponseEntity<List<Users>> listOfCustomer() throws UserException{
		
		List<Users> listOfusers = userService.viewAllCustomer();
		
		
		return new ResponseEntity<>(listOfusers, HttpStatus.OK);
	}
    
    
}
