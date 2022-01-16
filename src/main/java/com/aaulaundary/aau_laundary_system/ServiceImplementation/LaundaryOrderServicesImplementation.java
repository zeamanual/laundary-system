package com.aaulaundary.aau_laundary_system.ServiceImplementation;

import com.aaulaundary.aau_laundary_system.Repositories.LaundaryOrderRepository;
import com.aaulaundary.aau_laundary_system.Services.LaundaryOrderServices;
import com.aaulaundary.aau_laundary_system.models.LaundaryOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaundaryOrderServicesImplementation implements LaundaryOrderServices {
    @Autowired
    private LaundaryOrderRepository laundaryOrderRepository;

    @Override
    public LaundaryOrder saveLaundarOrder(LaundaryOrder laundaryOrder) {
        return laundaryOrderRepository.save(laundaryOrder);
    }

    @Override
    public LaundaryOrder findOrder(Long id) {
        if (laundaryOrderRepository.existsById(id)){
            return laundaryOrderRepository.findById(id).get();
       }
       return null;
    }

    @Override
    public void updateOrder(Long id, LaundaryOrder laundaryOrder) {
        if (laundaryOrderRepository.existsById(id)){
            laundaryOrderRepository.save(laundaryOrder);
        }  
        
    }
    
}