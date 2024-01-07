package com.example.springbootlesson.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatorClientMessage {
    private final Client client;
    private final Message message;

    @Autowired
    public CreatorClientMessage(Client client, Message message) {
        this.client = client;
        this.message = message;
    }

    public Client createClient() {
        return client;
    }

    public Message creteMessage(){
        return message;
    }
}
