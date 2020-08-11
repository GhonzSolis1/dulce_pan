package com.dulcepan.service;

import com.dulcepan.entity.TypeProduct;

import java.util.List;

public interface TypeProductService {

    List<TypeProduct> findAll();

    List<TypeProduct> findByDescriptionTypeProduct(String description);
}
