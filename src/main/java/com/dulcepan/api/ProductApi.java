package com.dulcepan.api;

import com.dulcepan.api.data.ProductDataApi;
import com.dulcepan.dto.ProductDto; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ProductApi.PRODUCT_API)
public class ProductApi {

    public static final String PRODUCT_API = "/products" ;
    public static final String FIND_PRODUCT_ID = "/{id}";
    public static final String CREATE = "/create";

    @Autowired
    private ProductDataApi productDataApi;

    @GetMapping(FIND_PRODUCT_ID)
    public ResponseEntity<Object> findByProductId(@PathVariable("id") Integer id){
         return new ResponseEntity<>(productDataApi.findByProductId(id), HttpStatus.ACCEPTED);
    }

    @PostMapping(CREATE)
    public ResponseEntity<Object> createProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productDataApi.createProduct(productDto), HttpStatus.ACCEPTED);

    }

}
