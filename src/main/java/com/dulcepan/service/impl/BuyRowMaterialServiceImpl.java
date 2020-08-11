package com.dulcepan.service.impl;

import com.dulcepan.entity.SellRawMaterial;
import com.dulcepan.dao.BuyRawMaterialDao;
import com.dulcepan.service.BuyRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyRowMaterialServiceImpl implements BuyRawMaterialService {

    private BuyRawMaterialDao buyRawMaterialDao;

    @Autowired
    public BuyRowMaterialServiceImpl(BuyRawMaterialDao buyRawMaterialDao) {
        this.buyRawMaterialDao = buyRawMaterialDao;
    }

    @Override
    public List<SellRawMaterial> findAll() {
        return buyRawMaterialDao.findAll();
    }

    @Override
    public SellRawMaterial insertBuyRawMaterial(SellRawMaterial sellRawMaterial) {
        return buyRawMaterialDao.saveAndFlush(sellRawMaterial);
    }
}
