package com.dulcepan.service.impl;

import com.dulcepan.entity.Product;
import com.dulcepan.entity.TypeProduct;
import com.dulcepan.dao.ProductDao;
import com.dulcepan.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {

    private static Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);
    private ProductDao productDao;

    @Autowired
    ProductServiceImpl( ProductDao productDao){
        this.productDao = productDao;
    }

    @Transactional
    @Override
    public Product createProduct(Product product) {
        return productDao.saveAndFlush(product);
    }

    @Transactional
    @Override
    public List<Product> findAllProduct() {
        return productDao.findAll();
    }

    @Override
    @Transactional
    public Product updateProduct(Product product) {
        return productDao.saveAndFlush(product);
    }

    @Override
    public List<Product> findByDescriptionProductContaining(String description) {
        return productDao.findByDescriptionProductContaining(description);
    }

    @Override
    public List<Product> findByNameProductContaining(String nameProduct) {
        return productDao.findByNameProductContaining(nameProduct);
    }

    @Override
    public List<Product> findByTypeProduct(TypeProduct typeProduct) {
        return productDao.findByTypeProduct(typeProduct);
    }
}
