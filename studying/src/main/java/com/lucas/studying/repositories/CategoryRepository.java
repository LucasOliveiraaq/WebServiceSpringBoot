package com.lucas.studying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.studying.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
