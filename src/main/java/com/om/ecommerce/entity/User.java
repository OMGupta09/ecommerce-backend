package com.om.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String name;
    private String email;
    private String password;
    private String role;

}
