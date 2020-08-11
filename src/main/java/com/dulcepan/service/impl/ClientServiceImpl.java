package com.dulcepan.service.impl;

import com.dulcepan.api.exception.NotFoundException;
import com.dulcepan.entity.Client;
import com.dulcepan.dao.ClientDao;
import com.dulcepan.service.ClientService;
import com.mysql.cj.xdevapi.ClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

    private static Logger LOG = LoggerFactory.getLogger(ClientImpl.class);

    private ClientDao clientDao;

    @Autowired
    public ClientServiceImpl(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Override
    public Client createClient(Client client) {
        return clientDao.saveAndFlush(client);
    }

    @Override
    public List<Client> findAllClients() {
        return clientDao.findAll();
    }

    @Override
    public Client findByRut(String rut) {
        return clientDao.findByRut(rut);
    }

    @Override
    public Client updateClient(Client client) {
        return clientDao.save(client);
    }

    @Override
    public List<Client> findByNameClientContaining(String nameClient) {
        List<Client> clients = clientDao.findByNameClientContaining(nameClient);
        if(clients.size()>0)
            return  clients;
        else
            throw new NotFoundException("No se encuentra cliente con nombre: "+nameClient);
    }

    @Override
    public List<Client> findByPhoneContaining(String phone) {
        return clientDao.findByPhoneContaining(phone);
    }

    @Override
    public List<Client> findByAddressContaining(String address) {
        return  clientDao.findByAddressContaining(address);
    }

    @Override
    public List<Client> findByCommuneContaining(String commune) {
        return  clientDao.findByCommuneContaining(commune);
    }

    @Override
    public List<Client> findByNameMarketContaining(String nameMarket) {
        return  clientDao.findByNameMarketContaining(nameMarket);
    }


}
