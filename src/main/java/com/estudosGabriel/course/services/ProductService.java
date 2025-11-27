package com.estudosGabriel.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudosGabriel.course.entities.Product;
import com.estudosGabriel.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}

}
