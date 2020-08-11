package com.dulcepan.dao;

import com.dulcepan.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientDao extends JpaRepository<Client,Integer> {

    Client findByRut(String rut);

    List<Client> findByNameClientContaining(String nameClient);

    List<Client> findByPhoneContaining(String phone);

    List<Client> findByAddressContaining(String address);

    List<Client> findByCommuneContaining(String commune);

    List<Client> findByNameMarketContaining(String nameMarket);




}
