package com.dulcepan.api.data;

import com.dulcepan.api.swagger.ClientApiSwagger;
import com.dulcepan.dto.ClientDto;
import com.dulcepan.entity.Client;
import com.dulcepan.service.ClientService;
import com.dulcepan.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientDataApi {

    private ClientService clientService;
    @Autowired
    public ClientDataApi(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientDto createClient(ClientDto clientDto){
        Client client = ObjectMapperUtils.map(clientDto, Client.class);
        return ObjectMapperUtils.map(clientService.createClient(client),ClientDto.class);
    }

    public List<ClientDto> findAllClient(){
        return ObjectMapperUtils.mapAll(clientService.findAllClients(),ClientDto.class);
    }

    public ClientDto findByRut(String rut){
        return ObjectMapperUtils.map(clientService.findByRut(rut),ClientDto.class);
    }

    public List<ClientDto> findByNameClientContaining(String name){
        return ObjectMapperUtils.mapAll(clientService.findByNameClientContaining(name),ClientDto.class);
    }

    public ClientDto updateClient(ClientDto clientDto){
        Client client = ObjectMapperUtils.map(clientDto, Client.class);
        return  ObjectMapperUtils.map(clientService.updateClient(client),ClientDto.class);
    }
}
