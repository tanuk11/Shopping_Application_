package com.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class UserLogin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loginId;
   
	@Column(unique = true)
    private Integer userId;
	
	@Email(message = "Please Enter the proper email")
	private String userName;
	
	private String password;
	
}
