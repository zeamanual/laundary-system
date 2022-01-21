package com.aaulaundary.aau_laundary_system.controllers;

import java.net.http.WebSocket.Listener;

import com.aaulaundary.aau_laundary_system.Services.ClotheServices;
import com.aaulaundary.aau_laundary_system.Services.LaundaryOrderServices;
import com.aaulaundary.aau_laundary_system.Services.UserServices;
import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;
import com.aaulaundary.aau_laundary_system.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    private UserServices userServices;
    @Autowired
    private ClotheServices clotheServices;
    @Autowired
    private LaundaryOrderServices laundaryOrderServices;
    

 
    @GetMapping("/profile")
    public String toShowProfile(Model themodel){

       List<LaundaryOrder> order=  laundaryOrderServices.findAllOrder();


       Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       String username;
       if (auth instanceof UserDetails) {
           username = ((UserDetails)auth).getUsername();
       } else {
           username = auth.toString();
       } 

         User user= userServices.findUserByUsername(username);
         String userID=user.getUsername();

          themodel.addAttribute("user",user);
        //   System.out.println(user.getLastName());
          System.out.println(user.getUsername());
          List<LaundaryOrder> orders=laundaryOrderServices.findOrderByUsername(user.getUsername());
         themodel.addAttribute("order", orders);
        return "profile_page";
    }
    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("user") User user){

        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (auth instanceof UserDetails) {
            username = ((UserDetails)auth).getUsername();
        } else {
            username = auth.toString();
        } 
 
        User existingUser= userServices.findUserByUsername(username);
        user.setUsername(username);
        userServices.saveUser(user);
        
        return "redirect:/";

    }
    @DeleteMapping("/profile/delete")
    public String deleteUser(){

        Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (auth instanceof UserDetails) {
            username = ((UserDetails)auth).getUsername();
        } else {
            username = auth.toString();
        } 
          userServices.deleteUser(username);
          return "signup";
        
    }


    
}