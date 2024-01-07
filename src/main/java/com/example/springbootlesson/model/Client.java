package com.example.springbootlesson.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {
    @Value("${client.name}")
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public Client(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}