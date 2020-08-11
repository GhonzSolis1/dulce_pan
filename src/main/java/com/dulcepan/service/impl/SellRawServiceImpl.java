package com.dulcepan.service.impl;

import com.dulcepan.entity.RowMaterial;
import com.dulcepan.entity.SellRawMaterial;
import com.dulcepan.dao.RowMaterialDao;
import com.dulcepan.dao.SellRawMaterialDao;
import com.dulcepan.service.SellRawMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellRawServiceImpl implements SellRawMaterialService {
    private SellRawMaterialDao sellRawMaterialDao;
    private RowMaterialDao rowMaterialDao;

    @Autowired
    public SellRawServiceImpl(SellRawMaterialDao sellRawMaterialDao, RowMaterialDao rowMaterialDao) {
        this.sellRawMaterialDao = sellRawMaterialDao;
        this.rowMaterialDao = rowMaterialDao;
    }

    @Override
    public SellRawMaterial createSellRowMaterial(SellRawMaterial sellRawMaterial) {
        updateRowMaterial(sellRawMaterial);
        return sellRawMaterialDao.saveAndFlush(sellRawMaterial);
    }

    @Override
    public List<SellRawMaterial> findAll() {
        return sellRawMaterialDao.findAll();
    }

    private void updateRowMaterial(SellRawMaterial sellRawMaterial){

        RowMaterial rowMaterial =rowMaterialDao.findByRowMaterialId(sellRawMaterial.getRowMaterial().getRowMaterialId());
        rowMaterial.setQuantity(rowMaterial.getQuantity()+sellRawMaterial.getQuantity());
        rowMaterialDao.saveAndFlush(rowMaterial);

    }
}
