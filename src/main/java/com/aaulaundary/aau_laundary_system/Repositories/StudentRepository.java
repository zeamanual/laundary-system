package com.aaulaundary.aau_laundary_system.Repositories;

import com.aaulaundary.aau_laundary_system.models.Student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    
}
