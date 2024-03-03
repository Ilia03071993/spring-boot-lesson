package com.example.springbootlesson.service;

import com.example.springbootlesson.exception.NoSuchClientException;
import com.example.springbootlesson.entity.Client;
import com.example.springbootlesson.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Client> findAllByName(String name) {
        return clientRepository.findAllByName(name);
    }

    @Transactional(readOnly = true)
    public Client findByName(String name) {
        return clientRepository.findByName(name)
                .orElseThrow(() -> new NoSuchClientException("Client with name='%s' not found".formatted(name)));
    }

    @Transactional(readOnly = true)
    public Client getClientById(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchClientException("Client with id='%d' not found".formatted(id)));
    }

    @Transactional
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    @Transactional
    public void updateClient(Integer id, Client client) {
        Client updatableClient = clientRepository.findById(id)
                .orElseThrow(() -> new NoSuchClientException("Client with id='%d' not found".formatted(id)));

        updatableClient.setName(client.getName());

        clientRepository.save(updatableClient);
    }

    @Transactional
    public boolean updateClientNameById(Integer id, String name) {
        return clientRepository.updateNameById(id, name) > 0; //if update more then 0 string.
    }

    @Transactional
    public void deleteClient(Integer id) {
        clientRepository.deleteById(id);
    }
}