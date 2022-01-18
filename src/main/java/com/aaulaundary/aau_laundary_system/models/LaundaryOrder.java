package com.aaulaundary.aau_laundary_system.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class LaundaryOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private List<Clothe> clothes;
    private String date;
    private String paymentAmount;
    private boolean isCompleted;
    private String doormDelivered;

    public LaundaryOrder(String date, String paymentAmount, boolean isCompleted) {
        this.date = date;
        this.paymentAmount = paymentAmount;
        this.isCompleted = isCompleted;
    }
    public LaundaryOrder() {
    }

    
}
