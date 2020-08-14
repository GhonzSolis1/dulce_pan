package com.dulcepan.service.manager;

import com.dulcepan.dto.ProductDto;
import com.dulcepan.entity.Product;

public interface ManagementProductService {

    ProductDto createProductWithRecipeInitial(Product product);
}
