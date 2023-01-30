package com.lucas.studying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.studying.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
