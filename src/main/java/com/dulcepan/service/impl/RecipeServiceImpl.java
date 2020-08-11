package com.dulcepan.service.impl;

import com.dulcepan.entity.Product;
import com.dulcepan.entity.Recipe;
import com.dulcepan.dao.RecipeDao;
import com.dulcepan.service.manager.ManagerRowMaterialService;
import com.dulcepan.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {

    private RecipeDao recipeDao;
    private ManagerRowMaterialService managerRowMaterialService;


    @Autowired
    public RecipeServiceImpl(RecipeDao recipeDao, ManagerRowMaterialService managerRowMaterialService) {
        this.recipeDao = recipeDao;
        this.managerRowMaterialService = managerRowMaterialService;
    }

    @Transactional
    @Override
    public Recipe createRecipe(Recipe recipe) {
        return recipeDao.saveAndFlush(recipe);
    }

    @Transactional
    @Override
    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

    @Transactional
    @Override
    public List<Product> findByDistinctProduct() {
        return recipeDao.findByDistinctProduct();
    }

    @Override
    public List<Recipe> findByProduct(Product product) {
        return recipeDao.findByProduct(product);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return recipeDao.saveAndFlush(recipe);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {

        recipeDao.deleteById(recipe.getRecipeId());
    }
}
