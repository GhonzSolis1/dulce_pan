package com.dulcepan.service;

import com.dulcepan.entity.SellRawMaterial;

import java.util.List;

public interface SellRawMaterialService {

    SellRawMaterial createSellRowMaterial(SellRawMaterial sellRawMaterial);

    List<SellRawMaterial> findAll();
}
