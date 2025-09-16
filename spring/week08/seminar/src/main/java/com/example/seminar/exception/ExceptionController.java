package com.example.seminar.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.seminar.exception.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/exception")
public class ExceptionController {

    @GetMapping
    public void getRuntimeException() {
        throw new RuntimeException("getRuntimeException 메서드 호출");
    }

    @GetMapping("/custom")
    public void getCustomException() throws CustomException {
        throw new CustomException(INTERNAL_SERVER_ERROR, "getCustomException 메서드 호출");
    }

}
