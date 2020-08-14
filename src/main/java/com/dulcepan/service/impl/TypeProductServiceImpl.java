package com.dulcepan.service.impl;

import com.dulcepan.dto.TypeProductDto;
import com.dulcepan.entity.TypeProduct;
import com.dulcepan.dao.TypeProductDao;
import com.dulcepan.service.TypeProductService;
import com.dulcepan.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeProductService")
public class TypeProductServiceImpl implements TypeProductService {

    private TypeProductDao typeProductDao;

    @Autowired
    public TypeProductServiceImpl(TypeProductDao typeProductDao) {
        this.typeProductDao = typeProductDao;
    }

    @Override
    public List<TypeProductDto> findAll() {
        return ObjectMapperUtils.mapAll(typeProductDao.findAll(),TypeProductDto.class);
    }

    @Override
    public List<TypeProductDto> findByDescriptionTypeProduct(String description) {
        return typeProductDao.findByDescriptionTypeProduct(description);
    }

    @Override
    public TypeProductDto create(TypeProduct typeProduct) {
        return ObjectMapperUtils.map(typeProductDao.saveAndFlush(typeProduct), TypeProductDto.class);
    }
}
