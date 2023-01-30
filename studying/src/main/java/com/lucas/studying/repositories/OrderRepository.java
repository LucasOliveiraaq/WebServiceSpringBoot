package com.lucas.studying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.studying.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
