package com.likelion.seminar.post.controller;

import com.likelion.seminar.post.dto.PostDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // final이 있는 건 생성자 필요 -> 생성자 필수인 것에 대해 생성자 자동 생성
@RequestMapping("post")   // post url로 받을거다
public class PostController {
    private final List<PostDTO> postDTOList;

    @PostMapping
    public void createPost(@RequestBody PostDTO postDTO) {
        System.out.println(postDTO.toString());
        this.postDTOList.add(postDTO);
    }

    @GetMapping
    public List<PostDTO> readPostAll() {
        System.out.println("포스트 전체 조회");
        return this.postDTOList;
    }

    @GetMapping("{id}")
    public PostDTO readPost(@PathVariable("id") int id) {
        System.out.println("포스트 단일 조회");
        return this.postDTOList.get(id);
    }

    @GetMapping("param")
    public PostDTO readPost_param(@RequestParam("id") int id) {
        System.out.println("포스트 단일 조회 2");
        return this.postDTOList.get(id);
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") int id, @RequestBody PostDTO postDTO) {
        PostDTO targetPost = this.postDTOList.get(id);
        if (postDTO.getTitle() != null) {
            targetPost.setTitle(postDTO.getTitle());
        }
        if (postDTO.getContent() != null) {
            targetPost.setContent(postDTO.getContent());
        }
        if (postDTO.getWriter() != null) {
            targetPost.setWriter(postDTO.getWriter());
        }
        this.postDTOList.set(id, targetPost);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id) {
        this.postDTOList.remove(id);
    }
}
