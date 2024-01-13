package com.morshed.SpringGraphqlPractice.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String mobileNumber;
    @ManyToOne
    private Designation designation;

    public Employee(){
    }



}
