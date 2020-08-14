package com.dulcepan.api.data;

import com.dulcepan.dto.ProductDto;
import com.dulcepan.entity.Product;
import com.dulcepan.service.ProductService;
import com.dulcepan.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
public class ProductDataApi {

    @Autowired
    private ProductService productService;

    public ProductDto findByProductId(@PathVariable("id") Integer id){
       return productService.findByProductId(id);
    }

    public ProductDto createProduct(@RequestBody ProductDto productDto){
       return productService.createProduct(ObjectMapperUtils.map(productDto, Product.class));
    }

}
