package com.bootcamp.bc_forum.entity;

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

@Entity // Mark the class as a JPA Entity
@Table(name = "Companies") 
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity {
    // Set Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto incremented ID
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}
