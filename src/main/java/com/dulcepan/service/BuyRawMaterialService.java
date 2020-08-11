package com.dulcepan.service;

import com.dulcepan.entity.SellRawMaterial;

import java.util.List;

public interface BuyRawMaterialService {

    List<SellRawMaterial> findAll();

    SellRawMaterial insertBuyRawMaterial(SellRawMaterial sellRawMaterial);
}
