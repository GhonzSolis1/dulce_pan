package com.dulcepan.service.impl;

import com.dulcepan.entity.*;
import com.dulcepan.dao.DailySaleDao;
import com.dulcepan.dao.DocumentDao;
import com.dulcepan.dao.ProductDailyDao;
import com.dulcepan.service.*;
import com.dulcepan.service.manager.ManagementProductDailyService;
import com.dulcepan.service.manager.ManagerDailySaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("dailySaleService")
public class DailySaleServiceImpl implements DailySaleService, ManagerDailySaleService {

    private static Logger LOG = LoggerFactory.getLogger(DailySaleServiceImpl.class);
    private DailySaleDao dailySaleDao;
    private ProductDailyDao productDailyDao;
    private ProductDailyService productDailyService;
    private DocumentDao documentDao;
    private ManagementProductDailyService managementProductDailyService;
    private PaymentDebtService paymentDebtService;

    @Autowired
    public DailySaleServiceImpl(DailySaleDao dailySaleDao,
                                ProductDailyService productDailyService,
                                ManagementProductDailyService managementProductDailyService,
                                DocumentDao documentDao,
                                ProductDailyDao productDailyDao,
                                PaymentDebtService paymentDebtService){
    this.dailySaleDao = dailySaleDao;
    this.managementProductDailyService = managementProductDailyService;
    this.productDailyService = productDailyService;
    this.documentDao = documentDao;
    this.productDailyDao = productDailyDao;
    this.paymentDebtService = paymentDebtService;
    }

    @Transactional
    @Override
    public DailySale createDailySale(DailySale dailySale) {
        managementProductDailyService.createStockProductDailyInSell(dailySale);
        dailySaleDao.saveAndFlush(dailySale);
        documentDao.saveAndFlush(dailySale.getDocument());
        return dailySale;
    }



    @Transactional
    @Override
    public List<DailySale> findByClient(Client client) {
        return dailySaleDao.findByClient(client);
    }

    @Transactional
    @Override
    public void deleteDailySale(DailySale dailySale) {
       // managementProductDailyService.additionStockProductDaily(dailySale);
        this.updateDocument(dailySale);
        this.updateDevolutionProductDaily(dailySale);
        dailySaleDao.delete(dailySale);

    }

    private void updateDevolutionProductDaily(DailySale dailySale){
        productDailyService.updateDevolutionProductDaily(dailySale);
    }

    private void updateDocument(DailySale dailySale){
        Document document = documentDao.findByDocumentId(dailySale.getDocument().getDocumentId());
        document.setTotalPayment(document.getTotalPayment()-dailySale.getPriceTotal());
        document.setDebtPending(document.getDebtPending()-dailySale.getPriceTotal());
        documentDao.saveAndFlush(document);
    }
    @Transactional
    @Override
    public DailySale updateDailySale(DailySale dailySale) {
        return dailySaleDao.saveAndFlush(dailySale);
    }

    @Override
    public List<DailySale> findByDocument(Document document) {
        return dailySaleDao.findByDocument(document);
    }

    @Override
    public void updateDailyProductAndProductDaily(DailySale dailySale) {

        ProductDaily productDaily = productDailyDao.findByProductDailyId(dailySale.getProductDaily().getProductDailyId());
        DailySale dailySaleReal = dailySaleDao.findByDailySaleId(dailySale.getDailySaleId());

        //cuando stock es mayor a modificar
        if(dailySale.getStock()>dailySaleReal.getStock()){
            Integer stockReal = dailySale.getStock()-dailySaleReal.getStock();
            updateDocumentWhenStockIsMajor(dailySale,stockReal*dailySale.getPriceReal());
            dailySaleReal.setStock(dailySaleReal.getStock()+stockReal);
            dailySaleReal.setPriceTotal(dailySaleReal.getStock()*dailySaleReal.getPriceReal());
            dailySaleDao.saveAndFlush(dailySaleReal);

         /*   PaymentDebt paymentDebt = PaymentDebt.builder()
                    .client(dailySaleReal.getClient())
                    .document(dailySaleReal.getDocument())
                    .

                    .build();
            paymentDebtService.insertPayment()*/

        }else if (dailySale.getStock()<dailySaleReal.getStock()){//cuando stock es menor a modificar
           // Integer stockReal = ds.getStock()-dailySale.getStock();
            Integer stockReal =dailySaleReal.getStock()- dailySale.getStock();
            updateDocumentWhenStockIsMinor(dailySale, stockReal*dailySale.getPriceReal());
            dailySaleReal.setStock(dailySaleReal.getStock()-stockReal);
            dailySaleReal.setPriceTotal(dailySaleReal.getStock()*dailySaleReal.getPriceReal());
            dailySaleDao.saveAndFlush(dailySaleReal);
        }
    }


    private void updateDocumentWhenStockIsMajor(DailySale dailySale, Integer priceTotal){
        Document document = documentDao.findByDocumentId(dailySale.getDocument().getDocumentId());
        document.setTotalPayment(document.getTotalPayment()+priceTotal);
        document.setDebtPending(document.getDebtPending()+priceTotal);
        documentDao.saveAndFlush(document);
    }

    private void updateDocumentWhenStockIsMinor(DailySale dailySale, Integer priceTotal){
        Document document = documentDao.findByDocumentId(dailySale.getDocument().getDocumentId());
        document.setTotalPayment(document.getTotalPayment()-priceTotal);
        document.setDebtPending(document.getDebtPending()-priceTotal);
        documentDao.saveAndFlush(document);
    }

    private void updateProductDailyWhenStockIsMajor(DailySale dailySale) {

    }

    private void updateProductDailyWhenStockIsMinor(DailySale dailySale){

    }

    @Transactional
    @Override
    public DailySale additionStockToDailySaleCreated(DailySale dailySale, Integer productId, Integer addition) {
        DailySale ds = new DailySale();
            managementProductDailyService.subtractionStockProductDailyId(productId, addition);
            BeanUtils.copyProperties(dailySale,ds);
            ds.setStock(ds.getStock() + addition);
            ds.setPriceTotal(ds.getStock() * ds.getPriceReal());
           return updateDailySale(ds);

    }
    @Transactional
    @Override
    public DailySale subtractionStockToDailySaleCreated(DailySale dailySale, Integer productId, Integer subtraction) {
      DailySale ds = new DailySale();
      DailySale dsReturn= new DailySale();
       if(dailySale.getStock()>=subtraction) {
           managementProductDailyService.additionStockProductDailyId(productId, subtraction);
           BeanUtils.copyProperties(dailySale,ds);
           ds.setStock(ds.getStock() - subtraction);
           ds.setPriceTotal(ds.getStock() * ds.getPriceReal());
           dsReturn = updateDailySale(ds);
       }
       return dsReturn;
    }
}
