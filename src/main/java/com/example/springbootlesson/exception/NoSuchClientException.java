package com.example.springbootlesson.exception;

public class NoSuchClientException extends RuntimeException{
    public NoSuchClientException(String message) {
        super(message);
    }
}
