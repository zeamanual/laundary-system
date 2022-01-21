package com.aaulaundary.aau_laundary_system.Repositories;

import com.aaulaundary.aau_laundary_system.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    public User findByUsername(String username);
    
}
