package com.dulcepan.service.manager;

import com.dulcepan.entity.DailySale;

public interface ManagerDailySaleService {

    DailySale additionStockToDailySaleCreated(DailySale dailySale, Integer productDailyId, Integer addition);

    DailySale subtractionStockToDailySaleCreated(DailySale dailySale, Integer productDailyId, Integer subtraction);

}
