package com.bootcamp.bc_forum.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    
    @Id // this is primary PK
    private Long id;

    private String name;
    private String username;
    private String email;
    // private AddressEntity addressEntity;
    private String phone;
    private String website;

}
