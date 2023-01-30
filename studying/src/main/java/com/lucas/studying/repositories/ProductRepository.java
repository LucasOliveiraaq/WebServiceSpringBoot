package com.lucas.studying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.studying.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
