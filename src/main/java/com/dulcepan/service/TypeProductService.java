package com.dulcepan.service;

import com.dulcepan.dto.TypeProductDto;
import com.dulcepan.entity.TypeProduct;

import java.util.List;

public interface TypeProductService {

    List<TypeProductDto> findAll();

    List<TypeProductDto> findByDescriptionTypeProduct(String description);

    TypeProductDto create(TypeProduct typeProduct);
}
