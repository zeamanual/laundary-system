package com.aaulaundary.aau_laundary_system.Services;


import com.aaulaundary.aau_laundary_system.models.Admin;




public interface AdminServices {

    public Admin saveAdmin(Admin admin);
    public void updateAdmin(Long id, Admin admin);
    public Admin findAdmin(Long id);
    public void deleteAdmin(Long id);   
}
