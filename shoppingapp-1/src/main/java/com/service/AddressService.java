package com.service;

import java.util.List;

import com.exception.AddressException;
import com.module.Address;



public interface AddressService {

	public Address addAddress(Address address);
	
	public Address updateAddress(Address address) throws AddressException;
	
	public List<Address> viewAllAddress() throws AddressException;
	
	public Address viewAddress(Integer customerId) throws AddressException;
}
