package com.estudosGabriel.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosGabriel.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
