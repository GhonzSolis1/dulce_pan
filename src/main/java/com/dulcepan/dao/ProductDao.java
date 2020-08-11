package com.dulcepan.dao;


import com.dulcepan.entity.Product;
import com.dulcepan.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    List<Product> findByDescriptionProductContaining(String description);

    List<Product> findByNameProductContaining(String nameProduct);

    List<Product> findByTypeProduct(TypeProduct typeProduct);



}
