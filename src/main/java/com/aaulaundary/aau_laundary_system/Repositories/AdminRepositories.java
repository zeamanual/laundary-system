package com.aaulaundary.aau_laundary_system.Repositories;

import com.aaulaundary.aau_laundary_system.models.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositories extends JpaRepository<Admin,Long> {
    
}
