package com.aaulaundary.aau_laundary_system.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Entity
@Data
public class Record {
    @Id
    private String id;

    public String getId() {
        return id;
    }

    public Record() {
    }

    public void setId(String id) {
        this.id = id;
    }


    
}
