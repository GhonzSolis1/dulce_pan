package com.dulcepan.service;

import com.dulcepan.entity.Client;
import com.dulcepan.entity.DailySale;
import com.dulcepan.entity.Document;

import java.util.List;

public interface DailySaleService{


    DailySale createDailySale(DailySale dailySale);


    List<DailySale> findByClient(Client clientId);

    void deleteDailySale(DailySale dailySaleId);

    DailySale updateDailySale(DailySale dailySale);

    List<DailySale> findByDocument(Document document);

    void updateDailyProductAndProductDaily(DailySale dailySale);


}
