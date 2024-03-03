package com.example.springbootlesson.controller;

import com.example.springbootlesson.entity.Client;
import com.example.springbootlesson.service.ClientService;
import com.example.springbootlesson.service.CreatorClientMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class ClientController {
    private final ClientService clientService;
    private final CreatorClientMessage creatorClientMessage;

    @ResponseBody
    @GetMapping("/client")
    public String getClients() {
        return creatorClientMessage.createClient().toString();
    }

    @GetMapping
    public String getClients(Model model) {
        List<Client> clients = new ArrayList<>(List.of(
                Client.builder().name("Ilya").build(), Client.builder().name("Bob").build(), Client.builder().name("Sara").build()
        ));
        model.addAttribute("clients", clients);
        return "/clients";
    }
}