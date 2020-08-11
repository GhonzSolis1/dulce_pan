package com.dulcepan.dao;

import com.dulcepan.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PaymentDebtDao extends JpaRepository<PaymentDebt,Integer> {

    PaymentDebt findByPaymentDebtId(Integer paymentDebtId);

    List<PaymentDebt> findByDocument(Document document);

    List<PaymentDebt> findByClient(Client client);

    List<PaymentDebt> findByTypePayment(TypePayment typePayment);

    List<PaymentDebt> findByDatePayment(Date datePayment);

    List<PaymentDebt> findByAmountPayment(Integer amountPayment);

}
