package com.dulcepan.service.impl;

import com.dulcepan.dto.ProductDto;
import com.dulcepan.entity.Product;
import com.dulcepan.entity.TypeProduct;
import com.dulcepan.dao.ProductDao;
import com.dulcepan.service.ProductService;
import com.dulcepan.util.ObjectMapperUtils;
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
    public ProductDto createProduct(Product product) {
        return ObjectMapperUtils.map(productDao.saveAndFlush(product),ProductDto.class);
    }

    @Override
    public ProductDto findByProductId(Integer productId) {
        return productDao.findByProductId(productId);
    }

    @Transactional
    @Override
    public List<ProductDto> findAllProduct() {
        return  ObjectMapperUtils.mapAll(productDao.findAll(),ProductDto.class);
    }

    @Override
    @Transactional
    public ProductDto updateProduct(Product product) {
        return ObjectMapperUtils.map(productDao.saveAndFlush(product),ProductDto.class);
    }

    @Override
    public List<ProductDto> findByDescriptionProductContaining(String description) {
        return productDao.findByDescriptionProductContaining(description);
    }

    @Override
    public List<ProductDto> findByNameProductContaining(String nameProduct) {
        return productDao.findByNameProductContaining(nameProduct);
    }

    @Override
    public List<ProductDto> findByTypeProduct(TypeProduct typeProduct) {
        return productDao.findByTypeProduct(typeProduct);
    }
}
