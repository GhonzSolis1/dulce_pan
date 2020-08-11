package com.dulcepan.service.impl;

import com.dulcepan.entity.*;
import com.dulcepan.dao.DailySaleDao;
import com.dulcepan.dao.ProductDailyDao;
import com.dulcepan.dao.RecipeDao;
import com.dulcepan.dao.RowMaterialDao;
import com.dulcepan.service.ProductDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Service("productDailyService")
public class ProductDailyServiceImpl implements ProductDailyService {

    private static Logger LOG = LoggerFactory.getLogger(ProductDailyServiceImpl.class);
    private ProductDailyDao productDailyDao;
    private RecipeDao recipeDao;
    private RowMaterialDao rowMaterialDao;
    private DailySaleDao dailySaleDao;



    @Autowired
    public ProductDailyServiceImpl(ProductDailyDao productDailyDao, RecipeDao recipeDao, RowMaterialDao rowMaterialDao,DailySaleDao dailySaleDao) {
    this.productDailyDao = productDailyDao;
    this.recipeDao = recipeDao;
    this.rowMaterialDao = rowMaterialDao;
    this.dailySaleDao = dailySaleDao;
    }
    @Transactional
    @Override
    public List<Date> findByDistinctDate() {
        return productDailyDao.findByDistinctDate();
    }

    @Transactional
    @Override
    public ProductDaily createProductDaily(ProductDaily productDaily) {
        List<Recipe> recipes = recipeDao.findByProduct(productDaily.getProduct());
       if(quantityValidation(recipes,productDaily.getStockDaily())) {

           processInRowMaterial(recipes,productDaily.getStockDaily());
           return productDailyDao.saveAndFlush(productDaily);
       }
          return new ProductDaily();
    }

    private void processInRowMaterial(List<Recipe> recipes, Integer stockDaily){
        for(Recipe r : recipes){
            RowMaterial rowMaterial = rowMaterialDao.findByRowMaterialId(r.getRowMaterial().getRowMaterialId());
                rowMaterial.setQuantity(rowMaterial.getQuantity()-(r.getQuantityPerProduct()*stockDaily));
                rowMaterialDao.save(rowMaterial);
        }
    }

    private void processSubtractProductDaily(List<Recipe> recipes, Integer stockDaily){
        for(Recipe r : recipes){
            RowMaterial rowMaterial = rowMaterialDao.findByRowMaterialId(r.getRowMaterial().getRowMaterialId());
            rowMaterial.setQuantity(rowMaterial.getQuantity()+(r.getQuantityPerProduct()*stockDaily));
            rowMaterialDao.saveAndFlush(rowMaterial);
        }
    }


    private Boolean quantityValidation(List<Recipe> recipes, Integer stockDaily) {

        for(Recipe r : recipes){
            RowMaterial rowMaterial = rowMaterialDao.findByRowMaterialId(r.getRowMaterial().getRowMaterialId());
            if(rowMaterial.getQuantity()<(r.getQuantityPerProduct()*stockDaily)){

                return  Boolean.FALSE;
            }
        }
        return Boolean.TRUE;

    }
    @Transactional
    @Override
    public List<ProductDaily> findAllProduct() {
        return productDailyDao.findAll();
    }

    @Transactional
    @Override
    public ProductDaily findByProductDailyId(Integer productDailyId) {
        return productDailyDao.findByProductDailyId(productDailyId);
    }
    @Transactional
    @Override
    public List<ProductDaily> findByProductDailyByProduct(Product product) {
        return productDailyDao.findByProduct(product);
    }
    @Transactional
    @Override
    public List<ProductDaily> findByStockDailyAndDate(Integer stockDaily, Date dateIni, Date dateEnd) {
        return productDailyDao.findByStockDailyGreaterThanAndBetweenDateDailyAndDateDaily(stockDaily, dateIni,dateEnd);
    }
    @Transactional
    @Override
    public List<ProductDaily> findByDateProductDaily(Date date) {
        return productDailyDao.findByDateDaily(date);
    }

    public void updateDevolutionProductDaily(DailySale dailySale){
        ProductDaily productDaily = productDailyDao.findByProductDailyId(dailySale.getProductDaily().getProductDailyId());
        productDaily.setStockDaily(productDaily.getStockDaily()+ dailySale.getStock());
        productDailyDao.saveAndFlush(productDaily);
    }

    @Transactional
    @Override
    public Boolean updateStockProductDaily(ProductDaily productDaily) {
        List<Recipe> recipes = recipeDao.findByProduct(productDaily.getProduct());
        if(productDaily.getStockDaily()>productDaily.getStockDailyHis()){
            int stockDaily = productDaily.getStockDaily()-productDaily.getStockDailyHis();
        if(quantityValidation(recipes,stockDaily)) {
            processInRowMaterial(recipes,stockDaily);
            productDaily.setStockDailyHis(productDaily.getStockDaily());
            productDailyDao.saveAndFlush(productDaily);
            return Boolean.TRUE;
        }
        }else if(productDaily.getStockDaily()<productDaily.getStockDailyHis()){
            int stockDaily =productDaily.getStockDailyHis()- productDaily.getStockDaily();
            processSubtractProductDaily(recipes,stockDaily);
            productDaily.setStockDailyHis(productDaily.getStockDaily());
            productDailyDao.saveAndFlush(productDaily);
            return Boolean.TRUE;
        }
        System.out.println("No Todo Ok");
        return Boolean.FALSE;
    }

    @Override
    public Boolean updateStockProductDailyInDeleteSell(ProductDaily productDaily) {
        List<Recipe> recipes = recipeDao.findByProduct(productDaily.getProduct());
        if(productDaily.getStockDaily()>productDaily.getStockDailyHis()){
            int stockDaily = productDaily.getStockDaily()-productDaily.getStockDailyHis();
            if(quantityValidation(recipes,stockDaily)) {
                processInRowMaterial(recipes,stockDaily);
                productDaily.setStockDailyHis(productDaily.getStockDailyHis());
                productDailyDao.saveAndFlush(productDaily);
                return Boolean.TRUE;
            }
        }else if(productDaily.getStockDaily()<productDaily.getStockDailyHis()){
            int stockDaily =productDaily.getStockDailyHis()- productDaily.getStockDaily();
            processSubtractProductDaily(recipes,stockDaily);
            productDaily.setStockDailyHis(productDaily.getStockDailyHis());
            productDailyDao.saveAndFlush(productDaily);
            return Boolean.TRUE;
        }
        System.out.println("No Todo Ok");
        return Boolean.FALSE;
    }

    @Override
    public Boolean deleteProductDaily(ProductDaily productDaily) {
       List<DailySale> dailySales= dailySaleDao.findByProductDaily(productDaily);
       if(dailySales.size()>0){//cuando está asociado a una venta no se puede eliminar
           return Boolean.FALSE;
       }else {
           List<Recipe> recipes = recipeDao.findByProduct(productDaily.getProduct());
           processSubtractProductDaily(recipes,productDaily.getStockDaily());
           productDailyDao.delete(productDaily);
           return Boolean.TRUE;
       }
    }

}
