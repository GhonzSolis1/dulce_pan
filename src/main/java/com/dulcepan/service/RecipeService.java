package com.dulcepan.service;

import com.dulcepan.entity.Product;
import com.dulcepan.entity.Recipe;
import com.dulcepan.entity.RowMaterial;

import java.util.List;

public interface RecipeService {

    Recipe createRecipe(Recipe recipe);

    List<Recipe> findAll();

    List<Product> findByDistinctProduct();

    List<Recipe> findByProduct(Product product);

    Recipe updateRecipe(Recipe recipe);

    void deleteRecipe(Recipe recipe);
}
