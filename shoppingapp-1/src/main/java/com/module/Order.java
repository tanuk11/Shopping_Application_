package com.module;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



public class Order {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer orderid;
	
	LocalDateTime localdtetime;
	String orderstatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	Users User;

	@OneToMany(cascade = CascadeType.ALL)
	List<Product>productlist;
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address;
}
