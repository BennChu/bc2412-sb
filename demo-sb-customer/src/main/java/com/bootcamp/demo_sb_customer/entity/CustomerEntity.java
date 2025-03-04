package com.bootcamp.demo_sb_customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// Convention Over Configuration

// Entity (Define Table Structure by Java)
// Hibernate is a framework -> rely on the driver, generate corresponding SQL
// jpa 內有 Hibernate
// mvn install -> test -> execute 會對一次 -> 
// PK, FK, auto_increment, column name, field size
// show-sql: true -> can see SQL

@Entity
@Table(name = "Customer")
@Getter
@Setter
@Builder
public class CustomerEntity {

    // native SQL -> 冇序, 唔係跟次序 map, 係跟 field name
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private Long id;
    @Column(name = "customer_name") // @Column(name="DESC", nullable=false, length=512)
    private String name;                //String varchar(225)
    @Column(name = "customer_email")
    private String email;

}
