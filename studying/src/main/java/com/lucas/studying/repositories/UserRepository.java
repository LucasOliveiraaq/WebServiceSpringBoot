package com.lucas.studying.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.studying.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
