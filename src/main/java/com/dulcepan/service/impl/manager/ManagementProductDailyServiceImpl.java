package com.dulcepan.service.impl.manager;

import com.dulcepan.entity.DailySale;
import com.dulcepan.entity.ProductDaily;
import com.dulcepan.service.manager.ManagementProductDailyService;
import com.dulcepan.service.ProductDailyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service("managerProductDailyService")
public class ManagementProductDailyServiceImpl implements ManagementProductDailyService {

    private static Logger LOG = LoggerFactory.getLogger(ManagementProductDailyServiceImpl.class);
    private ProductDailyService productDailyService;


    public ManagementProductDailyServiceImpl(ProductDailyService productDailyService) {
    this.productDailyService = productDailyService;
    }

    @Override
    public void subtractionStockProductDaily(DailySale dailySale) {

        productDailyService.updateStockProductDaily(subtraction(dailySale.getProductDaily().getProductDailyId(), dailySale.getStock()));
    }

    @Override
    public void createStockProductDailyInSell(DailySale dailySale) {
        productDailyService.updateStockProductDailyInDeleteSell(subtraction(dailySale.getProductDaily().getProductDailyId(), dailySale.getStock()));

    }

    private ProductDaily subtraction(Integer productDailyId, Integer subtraction){
        ProductDaily productDaily = productDailyService.findByProductDailyId(productDailyId);
        Integer subtractionStock = productDaily.getStockDaily() - subtraction;
        productDaily.setStockDaily(subtractionStock);
        return productDaily;
    }

    private ProductDaily subtractionDeleteInSell(Integer productDailyId, Integer subtraction){
        ProductDaily productDaily = productDailyService.findByProductDailyId(productDailyId);
        Integer subtractionStock = productDaily.getStockDaily() - subtraction;
        productDaily.setStockDaily(subtractionStock);
        return productDaily;
    }
    private ProductDaily addition(Integer productDailyId, Integer addition){
        ProductDaily productDaily = productDailyService.findByProductDailyId(productDailyId);
        Integer additionStock = productDaily.getStockDaily() + addition;
        productDaily.setStockDaily(additionStock);
        return productDaily;
    }
    @Override
    public void subtractionStockProductDailyId(Integer productId, Integer subtraction) {
        subtraction(productId, subtraction);
    }

    @Override
    public void additionStockProductDaily(DailySale dailySale) {
        productDailyService.updateStockProductDaily(addition(dailySale.getProductDaily().getProductDailyId(), dailySale.getStock()));

    }

    @Override
    public void additionStockProductDailyId(Integer productId, Integer subtraction) {
        addition(productId, subtraction);
    }
}
