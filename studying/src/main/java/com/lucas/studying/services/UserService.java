package com.lucas.studying.services;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.lucas.studying.entities.User;
import com.lucas.studying.repositories.UserRepository;
import com.lucas.studying.resources.exceptions.DatabaseException;
import com.lucas.studying.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		
		return repository.findAll();
	}
	
    @GetMapping(value = "/{id}")
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
    
    public User insert(User obj) {
    	return repository.save(obj);
    }
    
    public void delete(Long id) {
    	try {
    		repository.deleteById(id);
    	} catch (EmptyResultDataAccessException e) {
    		throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
    }
    
    public User update(Long id, User obj) {
    	try {			
    		User entity = repository.getReferenceById(id);
    		updateData(entity, obj);
    		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
    }
    
    private void updateData(User entity, User obj) {
    	entity.setName(obj.getName());
    	entity.setEmail(obj.getEmail());
    	entity.setPhone(obj.getPhone());
    }
}
