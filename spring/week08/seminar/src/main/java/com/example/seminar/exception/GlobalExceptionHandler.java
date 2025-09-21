package com.example.seminar.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        String field = ex.getBindingResult().getFieldErrors().get(0).getField();
        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

        LOGGER.error("Advice 내 methodArgumentNotValidException 호출, URI: {}, 메시지: {}",
                request.getRequestURI(), message);

        Map<String, String> map = new HashMap<>();
        map.put("error type", HttpStatus.BAD_REQUEST.getMessage());
        map.put("code", Integer.toString(HttpStatus.BAD_REQUEST.getCode()));
        map.put("message", message);
        map.put("error field", field);

        return ResponseEntity.status(400)
                .body(map);

    }

}
