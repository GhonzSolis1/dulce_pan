package com.dulcepan.service;

import com.dulcepan.entity.Provider;

import java.util.List;

public interface ProviderService {

    Provider createProvider(Provider provider);

    Provider updateProvider(Provider provider);

    List<Provider> findAll();

    List<Provider> findByNameContaining(String name);

    List<Provider> findByDescriptionContaining(String description);

    List<Provider> findByAddressContaining(String address);
}
