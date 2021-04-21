package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.entity.ClientEntity;
import com.siit.proiectfinalandreea.plantshop.exception.CategoryNotFoundException;
import com.siit.proiectfinalandreea.plantshop.exception.ClientNotFoundException;
import com.siit.proiectfinalandreea.plantshop.mapper.ClientMapper;
import com.siit.proiectfinalandreea.plantshop.model.ClientDto;
import com.siit.proiectfinalandreea.plantshop.model.ClientUpdateRequest;
import com.siit.proiectfinalandreea.plantshop.repository.CategoryRepository;
import com.siit.proiectfinalandreea.plantshop.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public List<ClientDto> getClients() {
        return clientMapper.mapListEntityToListDto(clientRepository.findAll());
    }

    public ClientDto getClient(Integer clientId) {
        return clientMapper.mapEntityToDto(clientRepository.findById(clientId).orElseThrow(() -> new ClientNotFoundException("No client for given ID  " + clientId)));
    }

    public ClientDto createClient(ClientDto client) {

        ClientEntity clientEntity = clientMapper.mapDtoToEntity(client);
        ClientEntity savedEntity = clientRepository.save(clientEntity);

        return clientMapper.mapEntityToDto(savedEntity);
    }
    @Transactional
    public ClientDto updateClient (ClientUpdateRequest clientUpdateRequest){

        ClientEntity clientEntityToSave = clientRepository.findById(clientUpdateRequest.getId()).orElseThrow(() -> new ClientNotFoundException("No client for given ID  " + clientUpdateRequest.getId()));
        if (clientUpdateRequest.getClientName()!=null){
            clientEntityToSave.setClientName(clientUpdateRequest.getClientName());
        }
        if (clientUpdateRequest.getAddressOfDelivery()!=null){
            clientEntityToSave.setAddressOfDelivery(clientUpdateRequest.getAddressOfDelivery());
        }
        if (clientUpdateRequest.getClientMail()!=null){
            clientEntityToSave.setClientMail(clientUpdateRequest.getClientMail());
        }
        return clientMapper.mapEntityToDto(clientEntityToSave);
    }

}
