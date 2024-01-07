package com.example.springbootlesson.controller;

import com.example.springbootlesson.model.Client;
import com.example.springbootlesson.model.CreatorClientMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
@Controller
public class ClientController {
    private final CreatorClientMessage creatorClientMessage;

    @Autowired
    public ClientController(CreatorClientMessage creatorClientMessage) {
        this.creatorClientMessage = creatorClientMessage;
    }

    @GetMapping("/client")
    public String getClients() {
        return creatorClientMessage.createClient().toString();
    }

    @GetMapping("/clients")
    public String getClients(Model model) {
        List<Client> clients = new ArrayList<>(List.of(
                new Client("Jake"), new Client("Bob"), new Client("Mike")
        ));
        model.addAttribute("clients", clients);
        return "views/clients";
    }
}
