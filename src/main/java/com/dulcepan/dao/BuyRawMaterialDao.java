package com.dulcepan.dao;

import com.dulcepan.entity.SellRawMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyRawMaterialDao extends JpaRepository<SellRawMaterial, Integer> {
}
