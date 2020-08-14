package com.dulcepan.dao;


import com.dulcepan.dto.ProductDto;
import com.dulcepan.entity.Product;
import com.dulcepan.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {

    List<ProductDto> findByDescriptionProductContaining(String description);

    List<ProductDto> findByNameProductContaining(String nameProduct);

    List<ProductDto> findByTypeProduct(TypeProduct typeProduct);

    ProductDto findByProductId(Integer productId);
}
