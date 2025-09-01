package com.example.seminar.controller;

import com.example.seminar.dto.BoardDetailDto;
import com.example.seminar.dto.BoardDto;
import com.example.seminar.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createBoard(@RequestBody String name) {
        return boardService.createBoard(name);
    }

    @GetMapping
    public List<BoardDto> getBoardList() {
        return boardService.getBoardList();
    }

    @GetMapping("/{id}")
    public BoardDetailDto getBoardDetail(@PathVariable("id") int id) {
        return boardService.getBoardDetail(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBoardTitle(@PathVariable("id") int id, @RequestBody String title) {
        boardService.updateBoardTitle(id, title);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBoard(@PathVariable("id") int id) {
        boardService.deleteBoard(id);
    }
}
