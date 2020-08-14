package com.dulcepan.service;

import com.dulcepan.dto.ProductDto;
import com.dulcepan.entity.Client;
import com.dulcepan.entity.Product;
import com.dulcepan.entity.TypeProduct;

import java.util.List;

public interface ProductService {


    ProductDto createProduct(Product product);

    ProductDto findByProductId(Integer productId);

    List<ProductDto> findAllProduct();

    ProductDto updateProduct(Product product);

    List<ProductDto> findByDescriptionProductContaining(String description);

    List<ProductDto> findByNameProductContaining(String nameProduct);

    List<ProductDto> findByTypeProduct(TypeProduct typeProduct);

}
