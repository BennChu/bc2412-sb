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

@Entity
@Table(name ="Comments") // in postgres Comments -> comments
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {
    
    @Id
    @Column(unique = true)
    private Long id;
    
    private String name;
    private String email;
    // @Column(columnDefinition = "TEXT")
    @Column(length = 320)
    private String body;

    @ManyToOne
    // @JsonProperty(value = "postId")
    @JoinColumn(name = "postId") // in postgres postId -> post_id, postid -> postid
    private PostEntity postEntity;
}
