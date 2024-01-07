package com.example.springbootlesson.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Message {
    @Value("${message.text}")
    private String text;

    public Message(String text) {
        this.text = text;
    }
    public Message(){}
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
