package com.yzakcarmo.springsecuritydemo.repositories;

import com.yzakcarmo.springsecuritydemo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByEmail(String email);
    List<User> findByNameContainingIgnoreCase(String name);
    List<User> getAllByRole(Integer role);
}
