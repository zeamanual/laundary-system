package com.aaulaundary.aau_laundary_system.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Student {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String campus;
    
    @Column(columnDefinition = "varchar(255) default 'User'")
    private String role;
    private String password;
    private String phoneNumber;
    
    public Student() {
    }

    public Student(String id, String firstName, String lastName, String email, String campus, String role,
            String password, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.campus = campus;
        this.role = role;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    



    
}
