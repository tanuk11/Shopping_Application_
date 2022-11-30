package com.service;

import java.util.List;

import com.exception.ProductException;
import com.module.Product;

public interface ProductService {

public Product addProducts(Product products) throws ProductException;
	
	public List<Product> getAllProducts() throws ProductException;
	
	public Product viewProductById(Integer id) throws ProductException;
	
	public Product deleteProductFromCatalog(Integer id) throws ProductException;
	
	public Product updateProductIncatalog(Product product) throws ProductException;
}
