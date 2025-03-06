package com.bootcamp.demo_sb_customer.entity.dto;

import java.io.Serializable;
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
@Table(name = "Companies")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompanyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String catchPrase;
    private String bs;

    @OneToOne
    @JoinColumn(name = "user_id") // @JoinColumn annotation indicates the column in the owning entity's table 
                                  // that references the primary key of the associated entity
    @Setter
    private UserEntity userEntity;
}
