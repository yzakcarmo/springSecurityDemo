package com.yzakcarmo.springsecuritydemo.services;

import com.yzakcarmo.springsecuritydemo.entities.User;
import com.yzakcarmo.springsecuritydemo.repositories.UserRepository;
import com.yzakcarmo.springsecuritydemo.services.exceptions.ResourceNotFoundException;
import com.yzakcarmo.springsecuritydemo.services.exceptions.DatabaseException;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<User> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name);
    }

    public List<User> getAllByRole(Integer role) {
        return repository.getAllByRole(role);
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void remove(Long id) {
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
        } catch(EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(User entity, User obj) {
        if(obj.getName() != null && !obj.getName().isEmpty())
            entity.setName(obj.getName());

        if(obj.getEmail() != null && !obj.getEmail().isEmpty())
            entity.setEmail(obj.getEmail());

        if(obj.getPhone() != null)
            entity.setPhone(obj.getPhone());
    }
}