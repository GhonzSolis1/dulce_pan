package com.dulcepan.api.data;

import com.dulcepan.dto.TypeProductDto;
import com.dulcepan.entity.TypeProduct;
import com.dulcepan.service.TypeProductService;
import com.dulcepan.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
public class TypeProductDataApi {
    @Autowired
    private TypeProductService typeProductService;

    public TypeProductDto createTypeProduct(TypeProductDto typeProductDto){
        return typeProductService.create(ObjectMapperUtils.map(typeProductDto, TypeProduct.class));
    }

    public List<TypeProductDto> findAll(){
        return typeProductService.findAll();
    }

}
