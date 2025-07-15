package com.likelion.seminar.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor // 모든 필드 받는 생성자
@ToString
public class PostDTO {
    private String title;
    private String content;
    private String writer;
}
