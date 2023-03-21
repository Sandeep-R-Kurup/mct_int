package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageid;
    private String sender;
    private String Reciever;
    private String message;
}
