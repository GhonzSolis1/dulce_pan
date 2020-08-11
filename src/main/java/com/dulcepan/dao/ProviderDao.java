package com.dulcepan.dao;

import com.dulcepan.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProviderDao extends JpaRepository<Provider, Integer> {

    List<Provider> findByNameContaining(String name);

    List<Provider> findByDescriptionContaining(String description);

    List<Provider> findByAddressContaining(String address);
}
