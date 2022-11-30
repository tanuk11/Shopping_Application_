package com.module;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer userId;
	private String userName;
	private String email;
	private String mobileNumber;
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address address;
	
	
	
	
	

}
