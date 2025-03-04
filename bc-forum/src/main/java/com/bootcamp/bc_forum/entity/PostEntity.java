package com.bootcamp.bc_forum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Posts")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {

    @Id
    @Column(unique = true)
    private Long id;

    private String title;
    private String body;

    @Setter
    @ManyToOne
    @JoinColumn(name = "userid")
    private UserEntity userEntity;
}
