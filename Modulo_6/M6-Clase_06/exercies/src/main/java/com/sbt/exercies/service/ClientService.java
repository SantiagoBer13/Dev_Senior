package com.sbt.exercies.service;

import java.util.List;
import java.util.Optional;

import com.sbt.exercies.models.Client;

public interface ClientService {

     List<Client> getAllClients();
     Client createClient(Client client);
     Optional<Client> getClient(Long id);
     void deleteClient(Long id);

}
