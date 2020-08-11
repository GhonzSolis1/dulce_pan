package com.dulcepan.service.impl;

import com.dulcepan.entity.Measure;
import com.dulcepan.entity.Recipe;
import com.dulcepan.entity.RowMaterial;
import com.dulcepan.dao.RowMaterialDao;
import com.dulcepan.service.manager.ManagerRowMaterialService;
import com.dulcepan.service.RowMaterialService;
import com.dulcepan.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("rowMaterialService")
public class RowMaterialServiceImpl implements RowMaterialService, ManagerRowMaterialService {


    private RowMaterialDao rowMaterialDao;

    @Autowired
    RowMaterialServiceImpl(RowMaterialDao rowMaterialDao) {
        this.rowMaterialDao = rowMaterialDao;
    }

    @Override
    public List<RowMaterial> findAll() {
        return rowMaterialDao.findAll();
    }

    @Override
    public List<RowMaterial> findByNameContaining(String name) {
        return rowMaterialDao.findByNameContaining(name);
    }

    @Override
    public List<RowMaterial> findByDescriptionContaining(String description) {
        return rowMaterialDao.findByDescriptionContaining(description);
    }

    @Override
    public List<RowMaterial> findByMeasureContaining(Measure measure) {
        return rowMaterialDao.findByMeasureContaining(measure);
    }

    @Transactional
    @Override
    public Boolean createRowMaterial(RowMaterial rowMaterial) {
        rowMaterialDao.saveAndFlush(rowMaterial);
        return findByIdRowMaterial(rowMaterial)!=null;
    }

    @Transactional
    @Override
    public RowMaterial findByIdRowMaterial(RowMaterial rowMaterial) {
        return rowMaterialDao.findByRowMaterialId(rowMaterial.getRowMaterialId());
    }

    @Transactional
    @Override
    public RowMaterial updateRowMaterial(RowMaterial rowMaterial) {
        return rowMaterialDao.saveAndFlush(rowMaterial);
    }

    @Transactional
    @Override
    public Integer subtractRowMaterial(Recipe recipe, Integer quantity) {
        RowMaterial rowMaterial = findByIdRowMaterial(recipe.getRowMaterial());
        Integer quantityTotal = recipe.getQuantityPerProduct()*quantity;
       if(recipe.getRowMaterial().getQuantity()>=quantityTotal) {
           updateRowMaterial(RowMaterial.builder()
                   .rowMaterialId(recipe.getRowMaterial().getRowMaterialId())
                   .quantity(recipe.getRowMaterial().getQuantity() - quantityTotal)
                   .build());
    return Utility.ROW_MATERIAL_SUBTRACT_OK;
       }
        return Utility.ROW_MATERIAL_SUBTRACT_QUANTITY_MINOR;
    }

    @Transactional
    @Override
    public void additionRowMaterial(Recipe recipe, Integer quantity) {
        updateRowMaterial(RowMaterial.builder()
                .rowMaterialId(recipe.getRowMaterial().getRowMaterialId())
                .quantity(recipe.getRowMaterial().getQuantity()+quantity)
                .build());
    }
}
