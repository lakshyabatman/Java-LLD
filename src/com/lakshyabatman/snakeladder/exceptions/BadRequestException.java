package com.lakshyabatman.snakeladder.exceptions;

public class BadRequestException extends Exception{
    BadRequestException() {

    }

    public BadRequestException(String message) {
        super(message);
    }

    BadRequestException(String message, Throwable error) {
        super(message,error);
    }
}
