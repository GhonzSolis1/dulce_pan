package com.dulcepan.api;

import com.dulcepan.api.data.TypeProductDataApi;
import com.dulcepan.dto.TypeProductDto;
import com.dulcepan.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(TypeProductApi.TYPES_PRODUCTS)
public class TypeProductApi {

    public static final String TYPES_PRODUCTS="/types-products";
    public static final String FIND_BY_TYPE_PRODUCT="/find-type-product/{typeProduct}";
    public static final String CREATE = "/create";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete/{id}";

    @Autowired
    private TypeProductDataApi typeProductDataApi;

    @GetMapping()
    public ResponseEntity<Object> findAll(){
        return new ResponseEntity<>(typeProductDataApi.findAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping(CREATE)
    public ResponseEntity<Object> createTypeProduct(@RequestBody TypeProductDto typeProductDto){
        return new ResponseEntity<>(typeProductDataApi.createTypeProduct(typeProductDto), HttpStatus.ACCEPTED) ;
    }



}
