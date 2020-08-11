package com.dulcepan.service.impl;

import com.dulcepan.entity.RecipeStatus;
import com.dulcepan.dao.RecipeStatusDao;
import com.dulcepan.service.RecipeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("recipeStatusService")
public class RecipeStatusServiceImpl implements RecipeStatusService {

    private RecipeStatusDao recipeStatusDao;

    @Autowired
    public RecipeStatusServiceImpl(RecipeStatusDao recipeStatusDao) {
        this.recipeStatusDao = recipeStatusDao;
    }

    @Override
    public RecipeStatus createRecipeStatus(RecipeStatus recipeStatus) {
        return recipeStatusDao.saveAndFlush(recipeStatus);
    }
}
