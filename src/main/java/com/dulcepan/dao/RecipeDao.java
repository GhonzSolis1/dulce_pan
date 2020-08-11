package com.dulcepan.dao;

import com.dulcepan.entity.Product;
import com.dulcepan.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RecipeDao extends JpaRepository<Recipe,Integer> {

    List<Recipe> findByProduct(Product product);

    @Query("Select Distinct(r.product) from Recipe r")
    List<Product> findByDistinctProduct();
 }
