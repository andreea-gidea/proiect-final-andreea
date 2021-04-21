package com.siit.proiectfinalandreea.plantshop.controller;

import com.siit.proiectfinalandreea.plantshop.model.ClientDto;
import com.siit.proiectfinalandreea.plantshop.model.ClientUpdateRequest;
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
    public List<ClientDto> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{clientID}")
    public ClientDto getClient(@PathVariable(name = "clientID") Integer clientID) {
        return clientService.getClient(clientID);
    }
    @PostMapping()
    public ClientDto createClient(@RequestBody ClientDto clientDto){
        return clientService.createClient(clientDto);
    }
    @PutMapping("/{clientID}")
    public ClientDto updateClient(@PathVariable(name = "clientID" ) Integer clientID, @RequestBody ClientUpdateRequest client){
        client.setId(clientID);
        return clientService.updateClient(client);
    }


}
