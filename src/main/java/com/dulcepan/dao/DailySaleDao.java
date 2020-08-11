package com.dulcepan.dao;

import com.dulcepan.entity.Client;
import com.dulcepan.entity.DailySale;
import com.dulcepan.entity.Document;
import com.dulcepan.entity.ProductDaily;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailySaleDao extends JpaRepository<DailySale,Integer> {


    DailySale findByDailySaleId(Integer dailySaleId);

    List<DailySale> findByProductDaily(ProductDaily productDaily);

    List<DailySale> findByClient(Client clientId);

    List<DailySale> findByDocument(Document document);

}
