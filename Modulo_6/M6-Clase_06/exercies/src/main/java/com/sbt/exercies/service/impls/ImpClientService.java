package com.sbt.exercies.service.impls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sbt.exercies.models.Client;
import com.sbt.exercies.repositories.ClientRepository;
import com.sbt.exercies.service.ClientService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ImpClientService implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> getClient(Long id){
        return clientRepository.findById(id);
    }

    @Override
    public void deleteClient(Long id){
        clientRepository.deleteById(id);
    }
    
}
