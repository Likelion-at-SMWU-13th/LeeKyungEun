package com.example.seminar.dao;

import com.example.seminar.entity.BoardEntity;
import com.example.seminar.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BoardDao {

    private final BoardRepository boardRepository;

    public long createBoard(String name) {
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setName(name);
        return boardRepository.save(boardEntity).getId();
    }

    public Iterator<BoardEntity> getBoardList() {
        return boardRepository.findAll().iterator();
    }

    public BoardEntity getBoard(int id) {
        Optional<BoardEntity> targetEntity = boardRepository.findById((long)id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BoardEntity boardEntity = targetEntity.get();
        return boardEntity;
    }

    public void updateBoardTitle(int id, String title) {
        Optional<BoardEntity> targetEntity = boardRepository.findById((long)id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        BoardEntity boardEntity = targetEntity.get();
        boardEntity.setName(title);

        boardRepository.save(boardEntity);
    }

    public void deleteBoard(int id) {
        Optional<BoardEntity> targetEntity = boardRepository.findById((long)id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.boardRepository.delete(targetEntity.get());
    }
}
