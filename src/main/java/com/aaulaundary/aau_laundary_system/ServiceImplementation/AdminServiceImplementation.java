package com.aaulaundary.aau_laundary_system.ServiceImplementation;

import com.aaulaundary.aau_laundary_system.Repositories.AdminRepositories;
import com.aaulaundary.aau_laundary_system.Services.AdminServices;
import com.aaulaundary.aau_laundary_system.models.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImplementation implements AdminServices {
    @Autowired
    AdminRepositories adminRepositories;

    @Override
    public Admin saveAdmin(Admin student) {
        return adminRepositories.save(student);
    }

    @Override
    public void updateAdmin(Long id, Admin student) {
         if (adminRepositories.existsById(id)){
            adminRepositories.save(student);
        }  
        
    }

    @Override
    public Admin findAdmin(Long id) {
        if (adminRepositories.existsById(id)){
            return adminRepositories.findById(id).get();
       }
       return null;
    }

    @Override
    public void deleteAdmin(Long id) {
        if(adminRepositories.existsById(id)){
            adminRepositories.deleteById(id);
        }
    }
}
