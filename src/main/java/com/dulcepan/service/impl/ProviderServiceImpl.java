package com.dulcepan.service.impl;

import com.dulcepan.entity.Provider;
import com.dulcepan.dao.ProviderDao;
import com.dulcepan.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    private ProviderDao providerDao;

    @Autowired
    public ProviderServiceImpl(ProviderDao providerDao) {
        this.providerDao = providerDao;
    }

    @Override
    public Provider createProvider(Provider provider) {
        return providerDao.saveAndFlush(provider);
    }

    @Override
    public Provider updateProvider(Provider provider) {
        return providerDao.saveAndFlush(provider);
    }

    @Override
    public List<Provider> findAll() {
        return providerDao.findAll();
    }

    @Override
    public List<Provider> findByNameContaining(String name) {
        return providerDao.findByNameContaining(name);
    }

    @Override
    public List<Provider> findByDescriptionContaining(String description) {
        return providerDao.findByDescriptionContaining(description);
    }

    @Override
    public List<Provider> findByAddressContaining(String address) {
        return providerDao.findByAddressContaining(address);
    }
}
