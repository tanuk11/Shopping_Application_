package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.module.Address;

public interface AddressRepo  extends JpaRepository<Address ,Integer>{

}
