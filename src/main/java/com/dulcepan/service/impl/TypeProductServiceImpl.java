package com.dulcepan.service.impl;

import com.dulcepan.entity.TypeProduct;
import com.dulcepan.dao.TypeProductDao;
import com.dulcepan.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeProductServiceImpl")
public class TypeProductServiceImpl implements TypeProductService {

    private TypeProductDao typeProductDao;

    @Autowired
    public TypeProductServiceImpl(TypeProductDao typeProductDao) {
        this.typeProductDao = typeProductDao;
    }

    @Override
    public List<TypeProduct> findAll() {
        return typeProductDao.findAll();
    }

    @Override
    public List<TypeProduct> findByDescriptionTypeProduct(String description) {
        return typeProductDao.findByDescriptionTypeProduct(description);
    }
}
