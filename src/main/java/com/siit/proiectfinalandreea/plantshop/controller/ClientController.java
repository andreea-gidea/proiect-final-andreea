package com.siit.proiectfinalandreea.plantshop.controller;

import com.siit.proiectfinalandreea.plantshop.entity.CategoryEntity;
import com.siit.proiectfinalandreea.plantshop.entity.ClientEntity;
import com.siit.proiectfinalandreea.plantshop.model.ClientDto;
import com.siit.proiectfinalandreea.plantshop.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping()
    public List<ClientEntity> getCategories() {
        return clientService.getClients();
    }

    @GetMapping("/{clientID}")
    public ClientEntity get(@PathVariable(name = "clientID") Integer clientID) {
        return clientService.getClient(clientID);
    }
    @PostMapping()
    public ClientDto create(@RequestBody ClientDto clientDto){
        return clientService.createClient(clientDto);
    }

}
