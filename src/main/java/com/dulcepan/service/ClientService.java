package com.dulcepan.service;

import com.dulcepan.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ClientService {

    Client createClient(Client client);

    List<Client> findAllClients();

    Client findByRut(String rut);

    Client updateClient(Client client);

    List<Client> findByNameClientContaining(String nameClient);

    List<Client> findByPhoneContaining(String phone);

    List<Client> findByAddressContaining(String address);

    List<Client> findByCommuneContaining(String commune);

    List<Client> findByNameMarketContaining(String nameMarket);


}
