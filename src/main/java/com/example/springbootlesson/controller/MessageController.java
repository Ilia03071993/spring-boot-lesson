package com.example.springbootlesson.controller;

import com.example.springbootlesson.model.CreatorClientMessage;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final CreatorClientMessage creatorClientMessage;

    @Autowired
    public MessageController(CreatorClientMessage creatorClientMessage) {
        this.creatorClientMessage = creatorClientMessage;
    }


    @GetMapping("/message")
    public String getMessage() {
        return creatorClientMessage.creteMessage().toString();
    }
}
