package com.dulcepan.service;

import com.dulcepan.entity.DailySale;
import com.dulcepan.entity.Product;
import com.dulcepan.entity.ProductDaily;

import java.util.Date;
import java.util.List;

public interface ProductDailyService {

    List<Date> findByDistinctDate();

    ProductDaily createProductDaily(ProductDaily productDaily) ;

    List<ProductDaily> findAllProduct();

    ProductDaily findByProductDailyId(Integer productDailyId);

    List<ProductDaily> findByProductDailyByProduct(Product product);

    List<ProductDaily> findByStockDailyAndDate(Integer stockDaily, Date dateIni, Date dateEnd);

    List<ProductDaily> findByDateProductDaily(Date date);

    Boolean updateStockProductDaily(ProductDaily productDaily);

    Boolean updateStockProductDailyInDeleteSell(ProductDaily productDaily);

    Boolean deleteProductDaily(ProductDaily productDaily);

    void updateDevolutionProductDaily(DailySale dailySale);
}
