package com.example.seminar.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "writer")
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    @ToString.Exclude
    private List<Post> posts = new ArrayList<>();

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setWriter(this);
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setWriter(this);
    }

}

