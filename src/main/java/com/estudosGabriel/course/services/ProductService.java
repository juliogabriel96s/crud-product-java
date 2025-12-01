package com.estudosGabriel.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudosGabriel.course.entities.Product;
import com.estudosGabriel.course.repositories.ProductRepository;
import com.estudosGabriel.course.services.exceptions.ResourceNotFound;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product insert(Product obj) {
		return repository.save(obj);
	}
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional <Product> obj = repository.findById(id);
		
		return obj.orElseThrow(() -> new ResourceNotFound(id));
	}
	
	public Product update(Long id, Product obj) {
		try {
			Product entity = repository.getReferenceById(id);
			updateData(entity, obj);
			
			return repository.save(entity);
			
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFound(id);
		}
	}
	
	private void updateData(Product entity, Product obj) {
		entity.setNome(obj.getNome());
		entity.setEstoque(obj.getEstoque());
		entity.setPreco(obj.getPreco());
	}

}
