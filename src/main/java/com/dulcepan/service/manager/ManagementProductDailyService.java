package com.dulcepan.service.manager;

import com.dulcepan.entity.DailySale;
import com.dulcepan.entity.Product;
import com.dulcepan.entity.ProductDaily;

import java.util.Date;
import java.util.List;

public interface ManagementProductDailyService {


    void subtractionStockProductDaily(DailySale dailySale);

    void createStockProductDailyInSell(DailySale dailySale);

    void subtractionStockProductDailyId(Integer productId, Integer subtraction);

    void additionStockProductDaily (DailySale dailySale);

    void additionStockProductDailyId(Integer productId, Integer subtraction);
}
