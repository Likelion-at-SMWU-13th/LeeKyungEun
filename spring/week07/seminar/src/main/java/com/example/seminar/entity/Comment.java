package com.example.seminar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer_id")
    @ToString.Exclude
    private Writer writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="post_id")
    @ToString.Exclude
    private Post post;

}
