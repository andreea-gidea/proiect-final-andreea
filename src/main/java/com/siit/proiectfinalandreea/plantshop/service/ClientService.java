package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.entity.ClientEntity;
import com.siit.proiectfinalandreea.plantshop.exception.CategoryNotFoundException;
import com.siit.proiectfinalandreea.plantshop.exception.ClientNotFoundException;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import com.siit.proiectfinalandreea.plantshop.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<ClientEntity> getClients() {
        return clientRepository.findAll();
    }

    public ClientEntity getClient(Integer clientId) {

        return clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("No such id for a client  "+clientId));
    }

}
