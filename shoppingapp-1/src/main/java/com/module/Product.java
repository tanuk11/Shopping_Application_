package com.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
		private Integer productId;
		private String productName;
		private double price;
		private String color;
		private Integer quantity;
		private String category;
}
