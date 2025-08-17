package com.sbt.exercies.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbt.exercies.models.Client;
import com.sbt.exercies.service.ClientService;
import com.sbt.exercies.service.impls.ImpClientService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/clients")
public class ClientController {

    private final ImpClientService clientService;

    @GetMapping("")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("")
    public Client createClient(@Valid @RequestBody Client client) {
        return clientService.createClient(client);
    }

    @GetMapping("{id}")
    public  Optional<Client> getClientById(@PathVariable Long id) {
        return clientService.getClient(id);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }
    
    
}
