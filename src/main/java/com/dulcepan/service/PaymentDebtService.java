package com.dulcepan.service;

import com.dulcepan.entity.*;

import java.util.Date;
import java.util.List;

public interface PaymentDebtService {


    PaymentDebt findByPaymentDebtId(Integer paymentDebtId);

    List<PaymentDebt> findAllPaymentDebt();

    List<PaymentDebt> findByDocument(Document document);

    List<PaymentDebt> findByClient(Client client);

    List<PaymentDebt> findByTypePayment(TypePayment typePayment);

    List<PaymentDebt> findByDatePayment(Date datePayment);

    List<PaymentDebt> findByAmountPayment(Integer amountPayment);

    PaymentDebt insertPayment (PaymentDebt paymentDebt);

}
