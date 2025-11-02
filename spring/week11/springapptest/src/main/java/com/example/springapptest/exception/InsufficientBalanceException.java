package com.example.springapptest.exception;

/**
 * 잔액 부족일 때 발생하는 예외
 */
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
