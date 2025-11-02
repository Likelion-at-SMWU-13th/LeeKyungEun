package com.example.springapptest.exception;

/**
 * 금액이 음수일 때 발생하는 예외
 */
public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}
