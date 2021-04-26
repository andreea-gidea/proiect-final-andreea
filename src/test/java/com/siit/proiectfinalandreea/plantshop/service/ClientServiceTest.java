package com.siit.proiectfinalandreea.plantshop.service;

import com.siit.proiectfinalandreea.plantshop.entity.ClientEntity;
import com.siit.proiectfinalandreea.plantshop.mapper.ClientMapper;
import com.siit.proiectfinalandreea.plantshop.model.ClientDto;
import com.siit.proiectfinalandreea.plantshop.repository.ClientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @Test
    public void getClientsWithEmptyList(){
        //Given
        List<ClientEntity> clientEntities = new ArrayList<>();
        when(clientRepository.findAll()).thenReturn(clientEntities);

        //When
        var clients = clientService.getClients();

        //Then
        assertThat(clients).isNotNull();
        assertThat(clients.isEmpty()).isEqualTo(true);
    }

    @Test
    public void getAllClients(){
        List<ClientEntity> clientEntities = new ArrayList<>();
        List<ClientDto> clientDtos = new ArrayList<>();
        var clientEntity = ClientEntity.builder()
                .id(1)
                .clientName("RAMON VALCAN")
                .clientMail("ramonvalcan@yahoo.com")
                .addressOfDelivery("Str. 5th, London")
                .build();

        clientEntities.add(clientEntity);
        clientEntities.add(clientEntity);

        var clientDto = ClientDto.builder()
                .id(1)
                .clientName("RAMON VALCAN")
                .clientMail("ramonvalcan@yahoo.com")
                .addressOfDelivery("Str. 5th, London")
                .dateCreatedAcc(LocalDate.now())
                .build();
        clientDtos.add(clientDto);
        clientDtos.add(clientDto);

        Mockito.when(clientRepository.findAll()).thenReturn(clientEntities);
        Mockito.when(clientMapper.mapListEntityToListDto(ArgumentMatchers.any())).thenReturn(clientDtos);

        var clients = clientService.getClients();

        assertThat(clients).isNotNull();
        assertThat(clients.size()).isEqualTo(2);
        assertThat(clients.get(0)).isNotNull();
        assertThat(clients.get(0).getClientName()).isEqualTo(clientEntity.getClientName());
        assertThat(clients.get(0).getClientMail()).isEqualTo(clientEntity.getClientMail());
        assertThat(clients.get(0).getAddressOfDelivery()).isEqualTo(clientEntity.getAddressOfDelivery());
        assertThat(clients.get(0).getDateCreatedAcc()).isEqualTo(clientEntity.getDateCreatedAcc());
    }

    @Test
    public void getClientById(){

        var clientEntity = ClientEntity.builder()
                .id(1)
                .clientName("RAMON VALCAN")
                .clientMail("ramonvalcan@yahoo.com")
                .addressOfDelivery("Str. 5th, London")
                .build();

        var clientDto = ClientDto.builder()
                .id(1)
                .clientName("RAMON VALCAN")
                .clientMail("ramonvalcan@yahoo.com")
                .addressOfDelivery("Str. 5th, London")
                .dateCreatedAcc(LocalDate.now())
                .build();

        Mockito.when(clientRepository.findById(1)).thenReturn(Optional.of(clientEntity));
        Mockito.when(clientMapper.mapEntityToDto(ArgumentMatchers.any())).thenReturn(clientDto);

        var client = clientService.getClient(1);

        assertThat(client).isNotNull();
        assertThat(client.getClientMail()).isEqualTo(clientEntity.getClientMail());
        assertThat(client.getClientName()).isEqualTo(clientEntity.getClientName());
        assertThat(client.getAddressOfDelivery()).isEqualTo(clientEntity.getAddressOfDelivery());
        assertThat(client.getDateCreatedAcc()).isEqualTo(clientEntity.getDateCreatedAcc());
    }

}