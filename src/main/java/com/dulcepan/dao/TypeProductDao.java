package com.dulcepan.dao;

import com.dulcepan.dto.TypeProductDto;
import com.dulcepan.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TypeProductDao extends JpaRepository<TypeProduct,Integer> {

    List<TypeProductDto> findByDescriptionTypeProduct(String description);
}
