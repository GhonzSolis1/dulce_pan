package com.dulcepan.dao;

import com.dulcepan.entity.Product;
import com.dulcepan.entity.ProductDaily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ProductDailyDao extends JpaRepository<ProductDaily,Integer> {

    @Query("Select Distinct(pd.dateDaily) from ProductDaily pd ORDER BY pd.dateDaily DESC")
    List<Date> findByDistinctDate();

    @Query("Select pd from ProductDaily pd where pd.stockDaily>=:stockDaily and pd.dateDaily between :dateIni and :dateEnd")
    List<ProductDaily> findByStockDailyGreaterThanAndBetweenDateDailyAndDateDaily(Integer stockDaily, Date dateIni, Date dateEnd);

    ProductDaily findByProductDailyId(Integer productDailyId);

    List<ProductDaily> findByProduct(Product product);

    List<ProductDaily> findByDateDaily(Date date);
}
