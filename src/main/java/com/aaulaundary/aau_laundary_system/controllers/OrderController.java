package com.aaulaundary.aau_laundary_system.controllers;

import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class OrderController {
    @GetMapping(value="/order")
    public String displayOrderPage(Model model) {
        LaundaryOrder laundaryOrder = new LaundaryOrder();
        
        return "order";
        
    }
    
    
}
