package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.exception.ProductException;
import com.module.Product;

import com.repository.ProductRepo;

public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo proRepo;
	
	@Override
	public Product addProducts(Product products) throws ProductException {
		return proRepo.save(products);
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
      List<Product> list = proRepo.findAll();
		
		if (list.size() > 0) {
			return list;
		} else
			throw new ProductException("No products in catalog");
	}

	@Override
	public Product viewProductById(Integer id) throws ProductException {
		 Optional<Product> opt = proRepo.findById(id);
			if(opt.isPresent()) {
		 Product  viewProduct = opt.get();
	
				
				return viewProduct;
				
			}
			else {
				throw new ProductException("No Product exist with this id");
			}
	}

	@Override
	public Product deleteProductFromCatalog(Integer id) throws ProductException {
		 Optional<Product> opt = proRepo.findById(id);
			if(opt.isPresent()) {
		 Product removeProduct = opt.get();
		 proRepo.delete(removeProduct);
				
				return removeProduct;
				
			}
			else {
				throw new ProductException("No Productr exist with this id");
			}

		
	}

	@Override
	public Product updateProductIncatalog(Product product) throws ProductException {
		  Optional<Product> opt = proRepo.findById(product.getProductId());
			
			if(opt.isPresent()) {
		  Product updatedProduct = proRepo.save(product);
				
				return updatedProduct;
				
			}
			else {
				throw new ProductException("No Product exist with this id");
			}
	}

}
