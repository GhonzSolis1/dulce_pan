package com.dulcepan.service;

import com.dulcepan.entity.Client;
import com.dulcepan.entity.Product;
import com.dulcepan.entity.TypeProduct;

import java.util.List;

public interface ProductService {


    Product createProduct(Product product);

    List<Product> findAllProduct();

    Product updateProduct(Product product);

    List<Product> findByDescriptionProductContaining(String description);

    List<Product> findByNameProductContaining(String nameProduct);

    List<Product> findByTypeProduct(TypeProduct typeProduct);

}
