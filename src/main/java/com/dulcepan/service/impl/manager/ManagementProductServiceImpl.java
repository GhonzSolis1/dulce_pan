package com.dulcepan.service.impl.manager;

import com.dulcepan.entity.*;
import com.dulcepan.service.manager.ManagementProductService;
import com.dulcepan.service.ProductService;
import com.dulcepan.service.RecipeService;
import com.dulcepan.service.RecipeStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("managementProductService")
public class ManagementProductServiceImpl implements ManagementProductService {

    private static Logger LOG = LoggerFactory.getLogger(ManagementProductServiceImpl.class);
    private ProductService productService;
    private RecipeService recipeService;
    private RecipeStatusService recipeStatusService;

    @Autowired
    public ManagementProductServiceImpl(ProductService productService, RecipeService recipeService,RecipeStatusService recipeStatusService) {
        this.productService = productService;
        this.recipeService = recipeService;
        this.recipeStatusService = recipeStatusService;
    }

    @Transactional
    @Override
    public Product createProductWithRecipeInitial(Product product) {
        Product  productCreated= productService.createProduct(product);
       Recipe recipe = recipeService.createRecipe(recipe(productCreated));
        recipeStatusService.createRecipeStatus(RecipeStatus(recipe));

        return productCreated;
    }

    private RecipeStatus RecipeStatus(Recipe recipe){

        return RecipeStatus.builder()
                .recipe(recipe)
                .description("Iniciado")
                .build();
    }
    private Recipe recipe(Product productCreated){
       return  Recipe.builder()
                .product(productCreated)
                .measure(Measure.builder().measureId(Measure.UNDEFINED).build())
                .rowMaterial(RowMaterial.builder().rowMaterialId(RowMaterial.UNDEFINED).build())
                .quantityPerProduct(0)
                .build();
    }
}
