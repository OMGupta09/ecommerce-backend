package com.om.ecommerce.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private User user;

    private Double totalAmount;

    private LocalDateTime orderDate;

    private String status;

    @OneToMany(mappedBy = "order", cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<OrderItem> items;
}
