package com.bootcamp.demo_sb_customer.entity.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Addresses")
@Getter
//@Setter // at class level, can setter all variables, 睇你想唔想俾人 setter all
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incremented ID
    private Long id;
    
    private String street; // default 255
    private String suite;
    private String city;
    private String zipcode;

    // set FK relationship with UserEntity
    @OneToOne
    @JoinColumn(name = "user_id") // column name in the addresss table
    @Setter // if i put it here, only can setter this variable
    private UserEntity userEntity;
}
