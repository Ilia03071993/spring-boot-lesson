package com.example.springbootlesson.controller;

import com.example.springbootlesson.service.CreatorClientMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageController {
    private final CreatorClientMessage creatorClientMessage;

    @ResponseBody
    @GetMapping
    public String getMessage() {
        return creatorClientMessage.creteMessage().toString();
    }
}
