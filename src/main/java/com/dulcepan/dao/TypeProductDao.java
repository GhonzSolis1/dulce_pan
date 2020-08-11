package com.dulcepan.dao;

import com.dulcepan.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeProductDao extends JpaRepository<TypeProduct,Integer> {

    List<TypeProduct> findByDescriptionTypeProduct(String description);
}
