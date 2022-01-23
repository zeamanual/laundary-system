package com.aaulaundary.aau_laundary_system.controllers;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.aaulaundary.aau_laundary_system.Repositories.LaundaryOrderRepository;
import com.aaulaundary.aau_laundary_system.Services.ClotheServices;
import com.aaulaundary.aau_laundary_system.Services.LaundaryOrderServices;
import com.aaulaundary.aau_laundary_system.Services.UserServices;
import com.aaulaundary.aau_laundary_system.models.Clothe;
import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;
import com.aaulaundary.aau_laundary_system.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OrderController {

    @Autowired
    ClotheServices clotheServices;
    @Autowired
    LaundaryOrderServices laundaryOrderServices;
    @Autowired
    UserServices userServices;

    @GetMapping(value="/order")
    public String displayOrderPage(Model model) {
        List<Clothe> clothes = clotheServices.findAllClothes();
        LaundaryOrder laundaryOrder = new LaundaryOrder();
        List<String> timeIntervals = Arrays.asList("3:00 - 5:00 at Morning","6:00 - 7:00 at Lunch","9:00 - 11:00 at Evening");
        model.addAttribute("clothes", clothes);
        model.addAttribute("times",timeIntervals);
        model.addAttribute("order", laundaryOrder);

        // model.addAttribute("show", "no-show");
        return "order";
    }

    @PostMapping("/order")
    public String toSave(@RequestParam("value") List<Integer> quantity,@ModelAttribute("order") LaundaryOrder order,Model themodel){
     
        List<Clothe> clothes = clotheServices.findAllClothes();
        float total = 0;
        int totalNumberOfClothes=0;

       for(int i = 0;i<clothes.size();i++ ){
        if (quantity.get(i)==null){
            quantity.set(i, 0);
         }
        totalNumberOfClothes+=quantity.get(i);
          
           total = total + (quantity.get(i)*clothes.get(i).getWashPrice());


       }
       themodel.addAttribute("total", total);
   
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-yyyy HH:mm:ss");  
           Date date = new Date();  
           System.out.println(formatter.format(date));
           LaundaryOrder laundaryOrder = new LaundaryOrder();
            order.setDate(formatter.format(date));
            order.setPaymentAmount(total);
            order.setQuantity(totalNumberOfClothes);
            Object auth = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username;
            if (auth instanceof UserDetails) {
                username = ((UserDetails)auth).getUsername();
            } else {
                username = auth.toString();
            } 
            User user = userServices.findUserByUsername(username);
            order.setUser(user);
            laundaryOrderServices.saveLaundarOrder(order);
    return "orderTotalPrice";
        }

    
    
       
    
}
    

