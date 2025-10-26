package com.example.seminar.controller;

import com.example.seminar.dto.JoinDTO;
import com.example.seminar.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    public ResponseEntity<String> joinProcess(JoinDTO joinDTO) {

        joinService.joinProcess(joinDTO);

        return new ResponseEntity<>("회원가입 성공", HttpStatus.CREATED);
    }

}
