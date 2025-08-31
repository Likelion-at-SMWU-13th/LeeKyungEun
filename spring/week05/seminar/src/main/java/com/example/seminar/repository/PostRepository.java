package com.example.seminar.repository;

import com.example.seminar.entity.BoardEntity;
import com.example.seminar.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    int countByBoardEntity(BoardEntity boardEntity);
    Optional<List<PostEntity>> findByBoardEntity(BoardEntity boardEntity);
}
