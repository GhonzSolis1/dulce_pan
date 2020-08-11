package com.dulcepan.service.impl;

import com.dulcepan.entity.Client;
import com.dulcepan.entity.Document;
import com.dulcepan.entity.PaymentDebt;
import com.dulcepan.entity.TypePayment;
import com.dulcepan.dao.DocumentDao;
import com.dulcepan.dao.PaymentDebtDao;
import com.dulcepan.service.PaymentDebtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Transactional
@Service("paymentDebtService")
public class PaymentDebtServiceImpl implements PaymentDebtService {

    private PaymentDebtDao paymentDebtDao;
    private DocumentDao documentDao;


    @Autowired
    public PaymentDebtServiceImpl(PaymentDebtDao paymentDebtDao, DocumentDao documentDao) {
        this.paymentDebtDao = paymentDebtDao;
        this.documentDao = documentDao;
    }


    @Override
    public PaymentDebt findByPaymentDebtId(Integer paymentDebtId) {
        return paymentDebtDao.findByPaymentDebtId(paymentDebtId);
    }

    @Override
    public List<PaymentDebt> findAllPaymentDebt() {
        return paymentDebtDao.findAll();
    }

    @Override
    public List<PaymentDebt> findByDocument(Document document) {
        return paymentDebtDao.findByDocument(document);
    }

    @Override
    public List<PaymentDebt> findByClient(Client client) {
        return paymentDebtDao.findByClient(client);
    }

    @Override
    public List<PaymentDebt> findByTypePayment(TypePayment typePayment) {
        return paymentDebtDao.findByTypePayment(typePayment);
    }

    @Override
    public List<PaymentDebt> findByDatePayment(Date datePayment) {
        return paymentDebtDao.findByDatePayment(datePayment);
    }

    @Override
    public List<PaymentDebt> findByAmountPayment(Integer amountPayment) {
        return paymentDebtDao.findByAmountPayment(amountPayment);
    }

    @Transactional
    @Override
    public PaymentDebt insertPayment(PaymentDebt paymentDebt) {
        Document document = documentDao.findByDocumentId(paymentDebt.getDocument().getDocumentId());
        document.setDebtPending(document.getDebtPending()-paymentDebt.getAmountPayment());
        return paymentDebtDao.saveAndFlush(paymentDebt);
    }
}
