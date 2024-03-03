package com.example.springbootlesson.service;

import com.example.springbootlesson.entity.Client;
import com.example.springbootlesson.entity.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class CreatorClientMessage {
    @Value("${client.name}")
    private String name;
    @Value("${message.text}")
    private String text;

    public Client createClient() {
        return Client.builder().name(name).build();
    }

    public Message creteMessage() {
        return Message.builder().text(text).build();
    }
}
