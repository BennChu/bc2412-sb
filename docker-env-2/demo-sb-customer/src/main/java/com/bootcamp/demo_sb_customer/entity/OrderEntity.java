package com.bootcamp.demo_sb_customer.entity;

import java.time.LocalDate;
//import org.springframework.data.annotation.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Orders")
@Getter
@Setter
public class OrderEntity {
    @Id // import the second @Id, should be jakarta.persistence.Id;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;
    
    private Double amount;
    @Column(name = "order_date")
    private LocalDate orderDate;

    // FK
    @ManyToOne //at ordes table point of view, 1 customer has many orders
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerEntity;
}
